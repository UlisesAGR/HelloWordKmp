/*
 * WebviewUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.webview.viewmodel

sealed class WebviewUiEvent {
    internal data object Idle : WebviewUiEvent()
    data object ShowErrorDialog : WebviewUiEvent()
}
