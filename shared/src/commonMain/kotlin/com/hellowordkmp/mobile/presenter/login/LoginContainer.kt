/*
 * LoginContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.presenter.components.ButtonPrimaryCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.hellowordkmp.mobile.presenter.components.TextBigBoldCustom
import com.hellowordkmp.mobile.presenter.components.TextButtonCustom
import com.hellowordkmp.mobile.presenter.components.TextFieldCustom
import com.hellowordkmp.mobile.utils.values.Dimens
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.back
import hellowordkmp.shared.generated.resources.login
import hellowordkmp.shared.generated.resources.user
import hellowordkmp.shared.generated.resources.user_example
import hellowordkmp.shared.generated.resources.user_name
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginContainer(
    onBack: () -> Unit = {},
    onLoginSuccess: () -> Unit = {},
) {
    var userName by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Dimens.padding16),
        verticalArrangement = Arrangement.Center,
    ) {
        TextBigBoldCustom(
            text = stringResource(Res.string.login),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        TextFieldCustom(
            value = userName,
            onValueChange = { user ->
                userName = user
            },
            label = stringResource(Res.string.user_name),
            placeholder = stringResource(Res.string.user_example),
            leadingIcon = Icons.Default.Person,
            contentDescription = stringResource(Res.string.user),
            capitalization = KeyboardCapitalization.Words,
        )
        Spacer(modifier = Modifier.height(Dimens.height32))
        ButtonPrimaryCustom(
            text = stringResource(Res.string.login),
            onClick = {
                focusManager.clearFocus()
                if (userName.isNotBlank()) onLoginSuccess()
            },
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        TextButtonCustom(
            text = stringResource(Res.string.back),
            onClick = { onBack() },
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun LoginContainerPreview() {
    SafeScreenContainerTest {
        LoginContainer()
    }
}
