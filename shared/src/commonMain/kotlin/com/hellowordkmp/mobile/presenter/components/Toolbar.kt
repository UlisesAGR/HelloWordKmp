/*
 * Toolbar.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.icon
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarCustom(
    modifier: Modifier = Modifier,
    title: String = "",
    icon: ImageVector? = null,
    onBack: (() -> Unit) = {},
) {
    TopAppBar(
        modifier = modifier,
        title = {
            TextBigBoldCustom(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                textAlign  = TextAlign.Start,

            )
        },
        navigationIcon = {
            icon?.let {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = icon,
                        contentDescription = stringResource(Res.string.icon),
                    )
                }
            }
        },
    )
}

@Preview(
    showBackground = true,
)
@Composable
private fun ToolbarPreview() {
    SafeScreenContainerTest {
        ToolbarCustom(
            title = "Example",
            icon = Icons.AutoMirrored.Filled.ArrowBack,
        )
    }
}
