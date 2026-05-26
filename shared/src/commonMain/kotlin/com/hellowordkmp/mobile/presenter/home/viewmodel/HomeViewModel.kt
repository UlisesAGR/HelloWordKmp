/*
 * HomeViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellowordkmp.mobile.domain.model.UserModel
import com.hellowordkmp.mobile.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {

    private val _homeUiState = MutableStateFlow<List<UserModel>>(emptyList())
    val homeUiState = _homeUiState.asStateFlow()

    private val _homeUiEvent = MutableStateFlow<List<UserModel>>(emptyList())
    val homeUiEvent = _homeUiEvent.asStateFlow()

    init {
        getUser()
    }

    private fun getUser() = viewModelScope.launch {
        getUsersUseCase(
            url = "user"
        ).onStart {

        }.catch {

        }.collect {

        }
    }
}
