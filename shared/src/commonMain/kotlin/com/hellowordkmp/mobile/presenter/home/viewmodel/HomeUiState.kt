/*
 * HomeUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.viewmodel

import com.hellowordkmp.mobile.domain.model.UserModel

data class HomeUiState(
    val isLoading: Boolean = false,
    val list: List<UserModel>? = null,
)
