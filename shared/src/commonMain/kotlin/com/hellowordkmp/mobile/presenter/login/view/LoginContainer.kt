/*
 * LoginContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.login.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.presenter.components.ButtonPrimaryCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.hellowordkmp.mobile.presenter.components.TextBigBoldCustom
import com.hellowordkmp.mobile.presenter.components.TextButtonCustom
import com.hellowordkmp.mobile.presenter.components.TextFieldCustom
import com.hellowordkmp.mobile.presenter.components.TextFieldPasswordCustom
import com.hellowordkmp.mobile.utils.values.Dimens
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.back
import hellowordkmp.shared.generated.resources.email
import hellowordkmp.shared.generated.resources.email_example
import hellowordkmp.shared.generated.resources.login
import hellowordkmp.shared.generated.resources.password
import hellowordkmp.shared.generated.resources.password_example
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginContainer(
    email: String = "",
    password: String = "",
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onLoginClick: () -> Unit = {},
    onBack: () -> Unit = {},
) {
    val focusManager = LocalFocusManager.current

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
            text = stringResource(Res.string.login),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        TextFieldCustom(
            value = email,
            onValueChange = onEmailChange,
            label = stringResource(Res.string.email),
            placeholder = stringResource(Res.string.email_example),
            leadingIcon = Icons.Default.Email,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        )
        TextFieldPasswordCustom(
            value = password,
            onValueChange = onPasswordChange,
            label = stringResource(Res.string.password),
            placeholder = stringResource(Res.string.password_example),
            leadingIcon = Icons.Default.Password,
            keyboardType = KeyboardType.Password,
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        ButtonPrimaryCustom(
            text = stringResource(Res.string.login),
            onClick = {
                focusManager.clearFocus()
                onLoginClick()
            },
        )
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
