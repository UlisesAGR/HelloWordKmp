/*
 * ProfileScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest

@Composable
fun ProfileScreen(
    onLogout: () -> Unit = {},
) {
    ProfileContent(
        onLogout = onLogout,
    )
}

@Preview(
    showBackground = true,
)
@Composable
private fun ProfileScreenPreview() {
    SafeScreenContainerTest {
        ProfileScreen()
    }
}
