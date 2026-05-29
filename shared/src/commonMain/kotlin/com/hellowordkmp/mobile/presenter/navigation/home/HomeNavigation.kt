/*
 * HomeNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.navigation.home

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.hellowordkmp.mobile.presenter.home.container.HomeScreenWithTabs

data object HomeScreenInstance : Screen {
    @Composable
    override fun Content() {
        HomeScreenWithTabs()
    }
}
