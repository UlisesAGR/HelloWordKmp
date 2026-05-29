/*
 * ProfileViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private var _profileUiState = MutableStateFlow(ProfileUiState())
    val profileUiState: StateFlow<ProfileUiState> = _profileUiState.asStateFlow()

    private var _profileUiEvent = MutableStateFlow<ProfileUiEvent>(ProfileUiEvent.Idle)
    val profileUiEvent: StateFlow<ProfileUiEvent> = _profileUiEvent.asStateFlow()

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
