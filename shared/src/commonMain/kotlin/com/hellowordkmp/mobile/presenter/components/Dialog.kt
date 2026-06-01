/*
 * Dialog.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.utils.values.Dimens
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun DialogCustom(
    title: String,
    message: String,
    buttonTextConfirm: String,
    buttonTextDismiss: String,
    onConfirm: () -> Unit = {},
    onDismiss: () -> Unit = {},
) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            ButtonPrimaryCustom(
                text = buttonTextConfirm,
                onClick = onConfirm,
            )
        },
        dismissButton = {
            ButtonSecondaryCustom(
                text = buttonTextDismiss,
                onClick = onDismiss,
            )
        },
    )
}

@Composable
fun ErrorDialogCustom(
    title: String,
    message: String,
    buttonText: String,
    onConfirm: () -> Unit = {},
) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            ButtonPrimaryCustom(
                text = buttonText,
                onClick = onConfirm,
            )
        },
    )
}

@Composable
fun ErrorDialogCustom(
    title: String,
    message: StringResource,
    buttonText: String,
    onConfirm: () -> Unit = {},
) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = title) },
        text = { Text(text = stringResource(message)) },
        confirmButton = {
            ButtonPrimaryCustom(
                text = buttonText,
                onClick = onConfirm,
            )
        },
    )
}

@Preview(
    showBackground = true,
)
@Composable
private fun DialogPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .padding(all = Dimens.padding16),
        ) {
            DialogCustom(
                title = "Example",
                message = "Example",
                buttonTextConfirm = "Example",
                buttonTextDismiss = "Example",
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun ErrorDialogPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .padding(all = Dimens.padding16),
        ) {
            ErrorDialogCustom(
                title = "Example",
                message = "Example",
                buttonText = "Example",
            )
        }
    }
}
