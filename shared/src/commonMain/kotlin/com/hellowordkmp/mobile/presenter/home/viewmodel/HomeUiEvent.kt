/*
 * HomeUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.viewmodel

sealed class HomeUiEvent {
    internal data object Idle : HomeUiEvent()
    data class ShowError(val exception: Throwable? = null) : HomeUiEvent()
}
