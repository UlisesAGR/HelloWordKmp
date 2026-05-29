/*
 * ProfileUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.profile.viewmodel

sealed class ProfileUiEvent {
    internal data object Idle : ProfileUiEvent()
    data object ShowInfoDialog : ProfileUiEvent()
    data object ShowErrorDialog : ProfileUiEvent()
}
