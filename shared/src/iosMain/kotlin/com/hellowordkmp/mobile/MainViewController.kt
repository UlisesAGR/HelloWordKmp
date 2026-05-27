package com.hellowordkmp.mobile

import androidx.compose.ui.window.ComposeUIViewController
import com.hellowordkmp.mobile.di.initKoin
import com.hellowordkmp.mobile.presenter.navigation.AppNavigation

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) {
    AppNavigation()
}
