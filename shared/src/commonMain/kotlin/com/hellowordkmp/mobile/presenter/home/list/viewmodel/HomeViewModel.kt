/*
 * ListViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellowordkmp.mobile.data.network.client.NetworkClient
import com.hellowordkmp.mobile.domain.model.UserModel
import com.hellowordkmp.mobile.domain.usecase.GetAllUsersUseCase
import com.hellowordkmp.mobile.domain.usecase.GetUsersUseCase
import com.hellowordkmp.mobile.domain.usecase.InsetUsersUseCase
import com.hellowordkmp.mobile.domain.usecase.SaveUserTokenUseCase
import dev.jordond.connectivity.Connectivity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val insetUsersUseCase: InsetUsersUseCase,
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val saveUserTokenUseCase: SaveUserTokenUseCase,
    private val connectivity: Connectivity,
) : ViewModel() {

    private var _listUiState = MutableStateFlow(HomeUiState())
    val listUiState: StateFlow<HomeUiState> = _listUiState.asStateFlow()

    private var _listUiEvent = MutableStateFlow<HomeUiEvent>(HomeUiEvent.Idle)
    val listUiEvent: StateFlow<HomeUiEvent> = _listUiEvent.asStateFlow()

    init {
        validateConnection()
        getUsers()
    }

    private fun validateConnection() = viewModelScope.launch {
        connectivity.start()
        val initialStatus = connectivity.status().isConnected
        _listUiState.update { state -> state.copy(isConnected = initialStatus) }
        connectivity.statusUpdates.map { status ->
            status.isConnected
        }.collect { connected ->
            _listUiState.update { state -> state.copy(isConnected = connected) }
        }
    }

    fun getUsers() = viewModelScope.launch {
        getUsersUseCase(
            url = NetworkClient.USERS_ENDPOINT,
        ).onStart {
            _listUiState.update { state -> state.copy(isLoading = true) }
        }.catch {
            _listUiEvent.emit(HomeUiEvent.ShowErrorDialog)
            _listUiState.update { state -> state.copy(isLoading = false) }
        }.collect { userList ->
            if (userList.isNotEmpty()) {
                insetUsers(userList = userList)
            } else {
                _listUiEvent.emit(HomeUiEvent.ShowErrorDialog)
                _listUiState.update { state -> state.copy(isLoading = false) }
            }
        }
    }

    private fun insetUsers(userList: List<UserModel>) = viewModelScope.launch {
        insetUsersUseCase(
            users = userList,
        ).catch {
            _listUiEvent.emit(HomeUiEvent.ShowErrorDialog)
            _listUiState.update { state -> state.copy(isLoading = false) }
        }.collect { userListSize ->
            if (userListSize.isNotEmpty()) {
                getAllUsers()
            } else {
                _listUiEvent.emit(HomeUiEvent.ShowErrorDialog)
                _listUiState.update { state -> state.copy(isLoading = false) }
            }
        }
    }

    private fun getAllUsers() = viewModelScope.launch {
        getAllUsersUseCase()
            .catch {
                _listUiEvent.emit(HomeUiEvent.ShowErrorDialog)
                _listUiState.update { state -> state.copy(isLoading = false) }
            }.collect { userList ->
                if (userList.isNotEmpty()) {
                    _listUiState.update { state -> state.copy(list = userList) }
                    saveUserToken(userToken = userList.first().name)
                } else {
                    _listUiEvent.emit(HomeUiEvent.ShowErrorDialog)
                    _listUiState.update { state -> state.copy(isLoading = false) }
                }
            }
    }

    private fun saveUserToken(userToken: String) = viewModelScope.launch {
        saveUserTokenUseCase(userToken)
            .catch {
                _listUiEvent.emit(HomeUiEvent.ShowErrorDialog)
                _listUiState.update { state -> state.copy(isLoading = false) }
            }.collect {
                _listUiState.update { state -> state.copy(isLoading = false) }
            }
    }

    fun retryGetUsers() = viewModelScope.launch {
        if (_listUiState.value.isConnected) {
            getUsers()
        } else {
            _listUiEvent.emit(HomeUiEvent.ShowErrorDialog)
        }
    }

    fun resetUiEvent() = viewModelScope.launch {
        _listUiEvent.value = HomeUiEvent.Idle
    }
}
