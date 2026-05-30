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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val insetUsersUseCase: InsetUsersUseCase,
    private val getAllUsersUseCase: GetAllUsersUseCase,
) : ViewModel() {

    private var _listUiState = MutableStateFlow(HomeUiState())
    val listUiState: StateFlow<HomeUiState> = _listUiState.asStateFlow()

    private var _listUiEvent = MutableStateFlow<HomeUiEvent>(HomeUiEvent.Idle)
    val listUiEvent: StateFlow<HomeUiEvent> = _listUiEvent.asStateFlow()

    fun getUsers() = viewModelScope.launch {
        getUsersUseCase(
            url = NetworkClient.USERS_ENDPOINT,
        ).onStart {
            _listUiState.update { state -> state.copy(isLoading = true) }
        }.catch { exception ->
            _listUiState.update { state -> state.copy(isLoading = false) }
            _listUiEvent.emit(HomeUiEvent.ShowErrorDialog(exception = exception.message.toString()))
        }.collect { userList ->
            _listUiState.update { state -> state.copy(isLoading = false) }
            if (userList.isNotEmpty()) {
                insetUsers(userList = userList)
            } else {
                _listUiEvent.emit(HomeUiEvent.ShowErrorDialog())
            }
        }
    }

    private fun insetUsers(userList: List<UserModel>) = viewModelScope.launch {
        insetUsersUseCase(
            users = userList,
        ).catch { exception ->
            _listUiState.update { state -> state.copy(isLoading = false) }
            _listUiEvent.emit(HomeUiEvent.ShowErrorDialog(exception = exception.message.toString()))
        }.collect { userListSize ->
            if (userListSize.isNotEmpty()) {
                getAllUsers()
            } else {
                _listUiState.update { state -> state.copy(isLoading = false) }
                _listUiEvent.emit(HomeUiEvent.ShowErrorDialog())
            }
        }
    }

    private fun getAllUsers() = viewModelScope.launch {
        getAllUsersUseCase()
            .catch { exception ->
                _listUiState.update { state -> state.copy(isLoading = false) }
                _listUiEvent.emit(HomeUiEvent.ShowErrorDialog(exception = exception.message.toString()))
            }.collect { userList ->
                if (userList.isNotEmpty()) {
                    _listUiState.update { state -> state.copy(list = userList) }
                } else {
                    _listUiState.update { state -> state.copy(isLoading = false) }
                    _listUiEvent.emit(HomeUiEvent.ShowErrorDialog())
                }
            }
    }

    fun resetUiEvent() = viewModelScope.launch {
        _listUiEvent.value = HomeUiEvent.Idle
    }
}
