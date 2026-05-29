/*
 * Dialog.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

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
