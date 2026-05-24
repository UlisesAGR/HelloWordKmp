package com.hellowordkmp.mobile.theme

import android.view.View
import android.view.Window
import androidx.core.view.WindowCompat

class AndroidSystemUiController(
    private val window: Window,
    private val view: View,
) : SystemUiController {
    override fun setSystemBarsColor(
        darkIcons: Boolean,
    ) {
        val controller = WindowCompat.getInsetsController(window, view)
        controller.isAppearanceLightStatusBars = darkIcons
        controller.isAppearanceLightNavigationBars = darkIcons
    }
}
