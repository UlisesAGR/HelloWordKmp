/*
 * HomeNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.navigation.home

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.hellowordkmp.mobile.presenter.home.container.MainScreenWithTabs
import com.hellowordkmp.mobile.presenter.navigation.login.WelcomeScreenInstance

data class HomeScreenInstance(val userName: String = "") : Screen {
    @Composable
    override fun Content() {
        val rootNavigator = LocalNavigator.currentOrThrow
        MainScreenWithTabs(
            userName = userName,
            onLogout = {
                rootNavigator.replaceAll(WelcomeScreenInstance)
            },
        )
    }
}
