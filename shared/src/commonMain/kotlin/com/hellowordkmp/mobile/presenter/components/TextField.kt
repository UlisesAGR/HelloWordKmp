/*
 * TextField.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun TextFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
    leadingIcon: ImageVector,
    contentDescription: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    onImeAction: () -> Unit = {},
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
        ),
        keyboardActions = KeyboardActions(
            onAny = {
                onImeAction()
                focusManager.clearFocus()
            },
        ),
        label = {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onBackground,
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                color = MaterialTheme.colorScheme.onBackground,
            )
        },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = contentDescription,
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
        )
    )
}
