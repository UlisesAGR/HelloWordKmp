/*
 * Text.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextSmallCustom(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall.copy(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
        ),
        color = color,
    )
}

@Composable
fun TextSmallBoldCustom(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall.copy(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        ),
        color = color,
    )
}

@Composable
fun TextMediumCustom(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
        ),
        color = color,
    )
}

@Composable
fun TextMediumBoldCustom(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        ),
        color = color,
    )
}

@Composable
fun TextBigCustom(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall.copy(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
        ),
        color = color,
    )
}

@Composable
fun TextBigBoldCustom(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall.copy(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        ),
        color = color,
    )
}
