/*
 * Button.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hellowordkmp.mobile.utils.values.Dimens

@Composable
fun ButtonPrimaryCustom(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
        )
    ) {
        TextMediumCustom(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background,
        )
    }
}

@Composable
fun ButtonSecondaryCustom(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary,
        )
    ) {
        TextMediumCustom(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background,
        )
    }
}

@Composable
fun TextButtonCustom(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
    ) {
        TextMediumCustom(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun ButtonPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
        ) {
            ButtonPrimaryCustom(text = "Example")
            ButtonSecondaryCustom(text = "Example")
            TextButtonCustom(text = "Example")
        }
    }
}
