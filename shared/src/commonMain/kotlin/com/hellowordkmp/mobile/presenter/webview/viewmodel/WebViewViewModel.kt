/*
 * WebViewViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.webview.viewmodel

import androidx.lifecycle.ViewModel
import com.multiplatform.webview.web.WebContent
import com.multiplatform.webview.web.WebViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WebViewViewModel : ViewModel() {

    private var _webViewUiState = MutableStateFlow(WebViewUiState())
    val webViewUiState: StateFlow<WebViewUiState> = _webViewUiState.asStateFlow()

    private var _webviewUiEvent = MutableStateFlow<WebviewUiEvent>(WebviewUiEvent.Idle)
    val webviewUiEvent: StateFlow<WebviewUiEvent> = _webviewUiEvent.asStateFlow()

    init {
        val url = "https://www.google.com"
        val webViewState = WebViewState(WebContent.Url(url = url))
        _webViewUiState.update { state -> state.copy(webViewState = webViewState) }
    }

    fun showErrorDialog() {
        _webviewUiEvent.value = WebviewUiEvent.ShowErrorDialog
    }

    fun resetUiEvent() {
        _webviewUiEvent.value = WebviewUiEvent.Idle
    }
}
