/*
 * HomeTabs.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.navigation.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.hellowordkmp.mobile.presenter.home.list.view.ListScreen
import com.hellowordkmp.mobile.presenter.home.profile.view.ProfileScreen
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.list
import hellowordkmp.shared.generated.resources.profile
import org.jetbrains.compose.resources.stringResource

object ListTab : Tab {
    override val options: TabOptions
        @Composable get() = TabOptions(
            index = 0u,
            title = stringResource(Res.string.list),
            icon = rememberVectorPainter(Icons.Default.Home),
        )
    @Composable
    override fun Content() {
        ListScreen()
    }
}

class ProfileTab(val onLogout: () -> Unit = {}) : Tab {
    override val options: TabOptions
        @Composable get() = TabOptions(
            index = 1u,
            title = stringResource(Res.string.profile),
            icon = rememberVectorPainter(Icons.Default.Person),
        )
    @Composable
    override fun Content() {
        ProfileScreen(
            onLogout = onLogout,
        )
    }
}
