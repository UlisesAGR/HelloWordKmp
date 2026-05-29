/*
 * WebViewUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.webview.viewmodel

import com.multiplatform.webview.web.WebViewState

data class WebViewUiState(
    val isLoading: Boolean = false,
    val webViewState: WebViewState? = null,
)
