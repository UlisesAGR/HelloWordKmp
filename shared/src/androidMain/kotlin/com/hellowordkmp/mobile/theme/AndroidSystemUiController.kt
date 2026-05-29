/*
 * AndroidSystemUiController.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.theme

import android.view.View
import android.view.Window
import androidx.core.view.WindowCompat

fun setSystemBarsColor(
    window: Window,
    view: View,
    darkIcons: Boolean,
) {
    WindowCompat.getInsetsController(window, view).apply {
        isAppearanceLightStatusBars = !darkIcons
        isAppearanceLightNavigationBars = !darkIcons
    }
}
