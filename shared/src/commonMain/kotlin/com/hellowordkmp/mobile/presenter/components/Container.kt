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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

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
