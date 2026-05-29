/*
 * ProfileContent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.profile.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.presenter.components.ButtonPrimaryCustom
import com.hellowordkmp.mobile.presenter.components.ButtonSecondaryCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainer
import com.hellowordkmp.mobile.utils.values.Dimens
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.logout
import hellowordkmp.shared.generated.resources.open_web
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProfileContent(
    onLogout: () -> Unit = {},
    onShowDialog: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Dimens.padding16),
        verticalArrangement = Arrangement.Center,
    ) {
        ButtonPrimaryCustom(
            text = stringResource(Res.string.logout),
            onClick = onLogout,
        )
        Spacer(modifier = Modifier.height(Dimens.padding32))
        ButtonSecondaryCustom(
            text = stringResource(Res.string.open_web),
            onClick = onShowDialog,
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun ProfileContentPreview() {
    SafeScreenContainer {
        ProfileContent()
    }
}
