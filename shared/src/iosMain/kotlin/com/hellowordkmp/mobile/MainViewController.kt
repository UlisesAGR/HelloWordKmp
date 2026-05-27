/*
 * MainViewController.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile

import androidx.compose.ui.window.ComposeUIViewController
import com.hellowordkmp.mobile.di.initKoin
import com.hellowordkmp.mobile.presenter.navigation.base.BaseNavigation

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) {
    BaseNavigation()
}
