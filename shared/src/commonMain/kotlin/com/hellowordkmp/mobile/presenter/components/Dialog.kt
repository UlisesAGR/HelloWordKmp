/*
 * ErrorDialog.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorDialogCustom(
    title: String,
    message: Throwable?,
    buttonText: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = title) },
        text = { Text(text = message?.message.toString()) },
        confirmButton = {
            ButtonCustom(
                text = buttonText,
                onClick = onDismiss,
            )
        }
    )
}
