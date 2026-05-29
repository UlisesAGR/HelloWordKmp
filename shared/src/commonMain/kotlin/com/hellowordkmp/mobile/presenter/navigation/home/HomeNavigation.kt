/*
 * HomeNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.navigation.home

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.hellowordkmp.mobile.presenter.home.container.HomeScreenWithTabs
import com.hellowordkmp.mobile.presenter.webview.view.WebViewScreen

data object HomeScreenInstance : Screen {
    @Composable
    override fun Content() {
        HomeScreenWithTabs()
    }
}

data object WebviewScreenInstance : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        WebViewScreen(
            onBack = {
                navigator.pop()
            },
        )
    }
}
