/*
 * WelcomeScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.presenter.components.ButtonCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainer
import com.hellowordkmp.mobile.presenter.components.TextBigCustom
import com.hellowordkmp.mobile.presenter.components.TextSmallCustom
import com.hellowordkmp.mobile.theme.AppTheme
import com.hellowordkmp.mobile.utils.permission.PermissionRequestEffect
import com.hellowordkmp.mobile.utils.values.Dimens
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.location.LOCATION
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.login
import hellowordkmp.shared.generated.resources.welcome_app
import org.jetbrains.compose.resources.stringResource

@Composable
fun WelcomeScreen(
    onNavigateToLogin: () -> Unit,
) {
    PermissionRequestEffect(permission = Permission.LOCATION)
    SafeScreenContainer {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.Center,
        ) {
            TextBigCustom(text = stringResource(Res.string.welcome_app))
            Spacer(modifier = Modifier.height(Dimens.padding8))
            TextSmallCustom(text = stringResource(Res.string.welcome_app))
            Spacer(modifier = Modifier.height(Dimens.height32))
            ButtonCustom(
                text = stringResource(Res.string.login),
                onClick = onNavigateToLogin,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    AppTheme {
        SafeScreenContainer {
            WelcomeScreen(
                onNavigateToLogin = {},
            )
        }
    }
}
