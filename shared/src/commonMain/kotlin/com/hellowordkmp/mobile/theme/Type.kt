package com.hellowordkmp.mobile.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.roboto_flex
import org.jetbrains.compose.resources.Font

@Composable
fun getAppTypography(): Typography {
    val font = FontFamily(
        Font(Res.font.roboto_flex, FontWeight.Normal),
        Font(Res.font.roboto_flex, FontWeight.Bold),
    )
    return Typography(
        headlineLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
        ),
        titleLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
        )
    )
}
