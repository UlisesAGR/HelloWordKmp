/*
 * HomeScreenWithTabs.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.container

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainer
import com.hellowordkmp.mobile.presenter.components.SafeScreenScaffoldContainer
import com.hellowordkmp.mobile.presenter.navigation.home.ListTab
import com.hellowordkmp.mobile.presenter.navigation.home.ProfileTab

@Composable
fun HomeScreenWithTabs() {
    SafeScreenContainer {
        TabNavigator(tab = ListTab) { tabNavigator ->
            SafeScreenScaffoldContainer(
                title = tabNavigator.current.options.title,
                tabs = listOf(
                    ListTab,
                    ProfileTab,
                ),
                content = {
                    CurrentTab()
                },
            )
        }
    }
}
