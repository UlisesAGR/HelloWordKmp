/*
 * WebViewContent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.webview.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewState

@Composable
fun WebViewContent(state: WebViewState? = null) {
    state?.let {
        WebView(state = state)
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun WebViewContentPreview() {
    SafeScreenContainerTest {
        WebViewContent()
    }
}
