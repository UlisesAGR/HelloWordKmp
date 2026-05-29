/*
 * HomeUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.list.viewmodel

sealed class HomeUiEvent {
    internal data object Idle : HomeUiEvent()
    data class ShowErrorDialog(val exception: String = "") : HomeUiEvent()
}
