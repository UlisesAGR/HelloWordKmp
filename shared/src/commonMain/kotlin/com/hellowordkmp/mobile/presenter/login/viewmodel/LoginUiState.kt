/*
 * LoginUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.login.viewmodel

data class LoginUiState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
)
