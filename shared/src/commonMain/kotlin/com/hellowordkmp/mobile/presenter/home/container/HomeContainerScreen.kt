/*
 * HomeContainerScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.container

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainer
import com.hellowordkmp.mobile.presenter.components.TabNavigationItem
import com.hellowordkmp.mobile.presenter.components.ToolbarCustom
import com.hellowordkmp.mobile.presenter.navigation.home.ListTab
import com.hellowordkmp.mobile.presenter.navigation.home.ProfileTab
import com.hellowordkmp.mobile.presenter.navigation.login.WelcomeScreenInstance

@Composable
fun HomeScreenWithTabs() {
    val rootNavigator = LocalNavigator.currentOrThrow
    SafeScreenContainer {
        TabNavigator(tab = ListTab) { tabNavigator ->
            Scaffold(
                topBar = {
                    ToolbarCustom(title = tabNavigator.current.options.title)
                },
                content = { padding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding),
                    ) {
                        CurrentTab()
                    }
                },
                bottomBar = {
                    NavigationBar {
                        TabNavigationItem(ListTab)
                        TabNavigationItem(
                            ProfileTab(
                                onLogout = {
                                    rootNavigator.replaceAll(WelcomeScreenInstance)
                                },
                            )
                        )
                    }
                },
            )
        }
    }
}
