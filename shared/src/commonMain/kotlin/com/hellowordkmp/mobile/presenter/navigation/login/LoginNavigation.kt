/*
 * LoginNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.navigation.login

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.hellowordkmp.mobile.presenter.login.LoginScreen
import com.hellowordkmp.mobile.presenter.navigation.home.HomeScreenInstance
import com.hellowordkmp.mobile.presenter.welcome.WelcomeScreen

data object WelcomeScreenInstance : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        WelcomeScreen(
            onNavigateToLogin = {
                navigator.push(LoginScreenInstance)
            },
        )
    }
}

data object LoginScreenInstance : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        LoginScreen(
            onBack = {
                navigator.pop()
            },
            onLoginSuccess = { userName ->
                navigator.replaceAll(HomeScreenInstance(userName))
            },
        )
    }
}
