/*
 * LoginViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myalbum2026.core.data.network.client.NetworkClient
import com.myalbum2026.core.domain.usecase.login.LoginUseCase
import com.myalbum2026.core.domain.usecase.login.ValidateLoginUseCase
import com.myalbum2026.core.domain.utils.ValidationResult
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.email_empty
import hellowordkmp.shared.generated.resources.password_empty
import hellowordkmp.shared.generated.resources.please_try_again_later
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val validateLoginUseCase: ValidateLoginUseCase,
    private val loginUseCase: LoginUseCase,
) : ViewModel() {

    private var _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    private var _loginUiEvent = MutableStateFlow<LoginUiEvent>(LoginUiEvent.Idle)
    val loginUiEvent: StateFlow<LoginUiEvent> = _loginUiEvent.asStateFlow()

    fun updateEmail(email: String) {
        _loginUiState.update { state -> state.copy(email = email) }
    }

    fun updatePassword(password: String) {
        _loginUiState.update { state -> state.copy(password = password) }
    }

    fun loginValidation(
        email: String,
        password: String,
    ) = viewModelScope.launch {
        when (validateLoginUseCase(email = email, password = password)) {
            is ValidationResult.EmailEmpty -> {
                _loginUiEvent.emit(LoginUiEvent.ShowErrorDialog(message = Res.string.email_empty))
            }
            is ValidationResult.PasswordEmpty -> {
                _loginUiEvent.emit(LoginUiEvent.ShowErrorDialog(message = Res.string.password_empty))
            }
            is ValidationResult.ValidationSuccess -> {
                login(
                    email = email,
                    password = password,
                )
            }
        }
    }

    private fun login(
        email: String,
        password: String,
    ) = viewModelScope.launch {
        loginUseCase(
            url = NetworkClient.LOGIN_ENDPOINT,
            email = email,
            password = password,
        ).onStart {
            _loginUiState.update { state -> state.copy(isLoading = true) }
        }.catch { exception ->
            print(exception)
            _loginUiEvent.emit(LoginUiEvent.ShowErrorDialog(message = Res.string.please_try_again_later))
            _loginUiState.update { state -> state.copy(isLoading = false) }
        }.collect { response ->
            if (response.status == 200) {
                _loginUiEvent.emit(LoginUiEvent.LoginSuccess)
            } else {
                _loginUiEvent.emit(LoginUiEvent.ShowErrorDialog(message = Res.string.please_try_again_later))
            }
            _loginUiState.update { state -> state.copy(isLoading = false) }
        }
    }

    fun resetUiEvent() {
        _loginUiEvent.value = LoginUiEvent.Idle
    }
}
