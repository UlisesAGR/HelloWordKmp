/*
 * AppActivity.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hellowordkmp.mobile.presenter.navigation.AppNavigation
import com.hellowordkmp.mobile.theme.AndroidSystemUiController

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { false }
        setContent {
//            val isDarkMode = isSystemInDarkTheme()
            SideEffect {
                AndroidSystemUiController(
                    window = window,
                    view = window.decorView,
                ).apply {
                    setSystemBarsColor(darkIcons = false)
                }
            }
            AppNavigation()
        }
    }
}
