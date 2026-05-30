/*
 * SafeScreenContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.tab.Tab
import com.hellowordkmp.mobile.theme.AppTheme

@Composable
fun SafeScreenContainer(
    modifier: Modifier = Modifier,
    systemColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    content: @Composable BoxScope.() -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = systemColor,
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .background(backgroundColor),
        ) {
            content()
        }
    }
}

@Composable
fun SafeScreenScaffoldContainer(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector? = null,
    onBack: (() -> Unit) = {},
    tabs: List<Tab>? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    SafeScreenContainer {
        Scaffold(
            modifier = modifier
                .fillMaxSize(),
            topBar = {
                ToolbarCustom(
                    title = title,
                    icon = icon,
                    onBack = onBack,
                )
            },
            content = { padding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                ) {
                    content()
                }
            },
            bottomBar = {
                tabs?.let {
                    NavigationBar {
                        tabs.forEach { tabs ->
                            TabNavigationItem(tabs)
                        }
                    }
                }
            },
        )
    }
}

@Composable
fun SafeScreenContainerTest(
    modifier: Modifier = Modifier,
    systemColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    content: @Composable BoxScope.() -> Unit,
) {
    AppTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = systemColor,
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .background(backgroundColor),
            ) {
                content()
            }
        }
    }
}
