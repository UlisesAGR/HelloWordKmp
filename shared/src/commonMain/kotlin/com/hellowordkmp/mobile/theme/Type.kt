/*
 * Type.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.open_sans
import org.jetbrains.compose.resources.Font

@Composable
fun getAppTypography(): Typography {
    val font = FontFamily(
        Font(Res.font.open_sans, FontWeight.Normal),
       Font(Res.font.open_sans, FontWeight.Bold),
    )
    return Typography(
        headlineLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        ),
        titleLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
        ),
        headlineMedium = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        titleMedium = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
        ),
        bodyMedium = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        labelMedium = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
        headlineSmall = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        ),
        titleSmall = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
        bodySmall = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        ),
        labelSmall = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
    )
}
