/*
 * ProfileViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellowordkmp.mobile.domain.usecase.GetUserTokenUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserTokenUseCase: GetUserTokenUseCase
) : ViewModel() {

    private var _profileUiState = MutableStateFlow(ProfileUiState())
    val profileUiState: StateFlow<ProfileUiState> = _profileUiState.asStateFlow()

    private var _profileUiEvent = MutableStateFlow<ProfileUiEvent>(ProfileUiEvent.Idle)
    val profileUiEvent: StateFlow<ProfileUiEvent> = _profileUiEvent.asStateFlow()

    init {
        getUserToken()
    }

    fun getUserToken() = viewModelScope.launch {
        getUserTokenUseCase()
            .onStart {
                _profileUiState.update { state -> state.copy(isLoading = true) }
            }.catch {
                _profileUiEvent.emit(ProfileUiEvent.ShowErrorDialog)
                _profileUiState.update { state -> state.copy(isLoading = false) }
            }.collect { userToken ->
                _profileUiState.update { state -> state.copy(userToken = userToken) }
                _profileUiState.update { state -> state.copy(isLoading = false) }
            }
    }

    fun showInfoDialog() = viewModelScope.launch {
        _profileUiEvent.value = ProfileUiEvent.ShowInfoDialog
    }

    fun showErrorDialog() = viewModelScope.launch {
        _profileUiEvent.value = ProfileUiEvent.ShowErrorDialog
    }

    fun resetUiEvent() = viewModelScope.launch {
        _profileUiEvent.value = ProfileUiEvent.Idle
    }
}
