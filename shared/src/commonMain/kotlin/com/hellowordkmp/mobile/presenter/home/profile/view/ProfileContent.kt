/*
 * ProfileContent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.profile.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.presenter.components.ButtonPrimaryCustom
import com.hellowordkmp.mobile.presenter.components.ButtonSecondaryCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.hellowordkmp.mobile.presenter.components.TextBigBoldCustom
import com.hellowordkmp.mobile.presenter.components.TextMediumCustom
import com.hellowordkmp.mobile.utils.values.Dimens
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.logout
import hellowordkmp.shared.generated.resources.na
import hellowordkmp.shared.generated.resources.open_browser
import hellowordkmp.shared.generated.resources.open_web_view
import hellowordkmp.shared.generated.resources.user_token
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProfileContent(
    userToken: String? = null,
    openWebview: () -> Unit = {},
    onShowDialog: () -> Unit = {},
    onLogout: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Dimens.padding16),
        verticalArrangement = Arrangement.spacedBy(
            space = Dimens.padding16,
            alignment = Alignment.CenterVertically,
        ),
    ) {
        TextBigBoldCustom(
            text = stringResource(Res.string.user_token),
            modifier = Modifier.fillMaxWidth(),
        )
        TextMediumCustom(
            text = if (!userToken.isNullOrEmpty()) userToken else stringResource(Res.string.na),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(Dimens.padding32))
        ButtonPrimaryCustom(
            text = stringResource(Res.string.open_web_view),
            onClick = openWebview,
        )
        ButtonSecondaryCustom(
            text = stringResource(Res.string.open_browser),
            onClick = onShowDialog,
        )
        ButtonPrimaryCustom(
            text = stringResource(Res.string.logout),
            onClick = onLogout,
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun ProfileContentPreview() {
    SafeScreenContainerTest {
        ProfileContent(
            userToken = "Example"
        )
    }
}
