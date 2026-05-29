/*
 * ListViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.list.viewmodel

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

class ListViewModel(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {

    private var _listUiState = MutableStateFlow(HomeUiState())
    val listUiState: StateFlow<HomeUiState> = _listUiState.asStateFlow()

    private var _listUiEvent = MutableStateFlow<HomeUiEvent>(HomeUiEvent.Idle)
    val listUiEvent: StateFlow<HomeUiEvent> = _listUiEvent.asStateFlow()

    init {
        getUser()
    }

    private fun getUser() = viewModelScope.launch {
        getUsersUseCase(
            url = "user"
        ).onStart {
            _listUiState.update { state -> state.copy(isLoading = true) }
        }.catch { exception ->
            _listUiState.update { state -> state.copy(isLoading = false) }
            _listUiEvent.emit(HomeUiEvent.ShowError(exception = exception))
        }.collect { userList ->
            _listUiState.update { state -> state.copy(isLoading = false) }
            if (userList.isNotEmpty()) {
                _listUiState.update { state -> state.copy(list = userList) }
            } else {
                _listUiEvent.emit(HomeUiEvent.ShowError())
            }
        }
    }

    fun resetUiEvent() = viewModelScope.launch {
        _listUiEvent.value = HomeUiEvent.Idle
    }
}
