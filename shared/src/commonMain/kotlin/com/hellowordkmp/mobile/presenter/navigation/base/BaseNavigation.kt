/*
 * BaseNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.navigation.base

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.ScaleTransition
import com.hellowordkmp.mobile.presenter.navigation.login.WelcomeScreenInstance
import com.hellowordkmp.mobile.theme.AppTheme

@Composable
fun BaseNavigation() {
    AppTheme {
        Navigator(screen = WelcomeScreenInstance) { navigator ->
            ScaleTransition(navigator)
        }
    }
}
