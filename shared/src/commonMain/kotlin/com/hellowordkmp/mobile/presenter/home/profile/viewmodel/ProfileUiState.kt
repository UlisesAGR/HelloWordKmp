/*
 * ProfileUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.profile.viewmodel

data class ProfileUiState(
    val isLoading: Boolean = false,
    val userToken: String? = null,
    val showDialog: Boolean = false,
)
