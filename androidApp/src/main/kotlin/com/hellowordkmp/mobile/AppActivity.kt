package com.hellowordkmp.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hellowordkmp.mobile.presenter.navigation.base.BaseNavigation
import com.hellowordkmp.mobile.theme.setSystemBarsColor

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { false }
        setContent {
            val isDarkMode = isSystemInDarkTheme()
            setSystemBarsColor(
                window = window,
                view = window.decorView,
                darkIcons = !isDarkMode,
            )
            BaseNavigation()
        }
    }
}
