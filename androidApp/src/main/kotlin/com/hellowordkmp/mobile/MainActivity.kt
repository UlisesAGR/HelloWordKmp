package com.hellowordkmp.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hellowordkmp.mobile.presenter.navigation.AppNavigation
import com.hellowordkmp.mobile.theme.AndroidSystemUiController

class MainActivity : ComponentActivity() {

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
