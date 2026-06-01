/*
 * LoginUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.login.viewmodel

import org.jetbrains.compose.resources.StringResource

sealed class LoginUiEvent {
    internal data object Idle : LoginUiEvent()
    data class ShowErrorDialog(val message: StringResource) : LoginUiEvent()
    data object LoginSuccess : LoginUiEvent()
}
