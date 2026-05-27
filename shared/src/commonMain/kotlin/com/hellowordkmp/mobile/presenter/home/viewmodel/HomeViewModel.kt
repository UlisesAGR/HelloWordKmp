/*
 * HomeViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellowordkmp.mobile.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {

    private var _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    private var _homeUiEvent = MutableStateFlow<HomeUiEvent>(HomeUiEvent.Idle)
    val homeUiEvent: StateFlow<HomeUiEvent> = _homeUiEvent.asStateFlow()

    init {
        getUser()
    }

    private fun getUser() = viewModelScope.launch {
        getUsersUseCase(
            url = "user"
        ).onStart {
            _homeUiState.update { state -> state.copy(isLoading = true) }
        }.catch { exception ->
            _homeUiState.update { state -> state.copy(isLoading = false) }
            _homeUiEvent.emit(HomeUiEvent.ShowError(exception = exception))
        }.collect { userList ->
            _homeUiState.update { state -> state.copy(isLoading = false) }
            if (userList.isNotEmpty()) {
                _homeUiState.update { state -> state.copy(list = userList) }
            } else {
                _homeUiEvent.emit(HomeUiEvent.ShowError())
            }
        }
    }

    fun resetUiEvent() = viewModelScope.launch {
        _homeUiEvent.value = HomeUiEvent.Idle
    }
}
