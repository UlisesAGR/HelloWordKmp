/*
 * WelcomeScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.welcome

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainer
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.hellowordkmp.mobile.utils.permission.PermissionRequestEffect
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.location.LOCATION

@Composable
fun WelcomeScreen(
    onNavigateToLogin: () -> Unit = {},
) {
    PermissionRequestEffect(permission = Permission.LOCATION)
    SafeScreenContainer {
        WelcomeContainer(
            onNavigateToLogin = onNavigateToLogin,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    SafeScreenContainerTest {
        WelcomeScreen()
    }
}
