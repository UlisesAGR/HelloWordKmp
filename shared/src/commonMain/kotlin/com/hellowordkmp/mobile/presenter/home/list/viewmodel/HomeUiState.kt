/*
 * HomeUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.list.viewmodel

import com.myalbum2026.core.domain.model.user.UserModel

data class HomeUiState(
    val isLoading: Boolean = false,
    val isConnected: Boolean = false,
    val list: List<UserModel>? = null,
)
