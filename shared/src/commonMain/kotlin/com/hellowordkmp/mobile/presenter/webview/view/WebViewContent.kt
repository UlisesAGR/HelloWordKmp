/*
 * WebViewContent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.webview.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewState

@Composable
fun WebViewContent(state: WebViewState) {
    WebView(
        state = state,
        modifier = Modifier.fillMaxSize()
    )
}
