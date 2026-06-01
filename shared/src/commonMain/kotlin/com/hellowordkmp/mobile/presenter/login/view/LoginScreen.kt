/*
 * LoginScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.login.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hellowordkmp.mobile.presenter.components.ErrorDialogCustom
import com.hellowordkmp.mobile.presenter.components.LoadingCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainer
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.hellowordkmp.mobile.presenter.login.viewmodel.LoginUiEvent
import com.hellowordkmp.mobile.presenter.login.viewmodel.LoginViewModel
import com.hellowordkmp.mobile.utils.animation.Animation
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.accept
import hellowordkmp.shared.generated.resources.idle
import hellowordkmp.shared.generated.resources.warning
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onBack: () -> Unit = {},
    onLoginSuccess: () -> Unit = {},
) {
    val loginUiState by viewModel.loginUiState.collectAsStateWithLifecycle()
    val loginUiEvent by viewModel.loginUiEvent.collectAsStateWithLifecycle()

    SafeScreenContainer {
        AnimatedContent(
            targetState = loginUiState.isLoading,
            transitionSpec = { Animation.scaleTransition() },
        ) { currentState ->

            LoginContainer(
                email = loginUiState.email,
                password = loginUiState.password,
                onEmailChange = { email ->
                    viewModel.updateEmail(email)
                },
                onPasswordChange = { password ->
                    viewModel.updatePassword(password)
                },
                onLoginClick = {
                    viewModel.loginValidation(
                        email = loginUiState.email,
                        password = loginUiState.password,
                    )
                },
                onBack = onBack,
            )

            if (currentState) {
                LoadingCustom()
            }
        }
    }

    when (loginUiEvent) {
        is LoginUiEvent.Idle -> print(stringResource(Res.string.idle))
        is LoginUiEvent.ShowErrorDialog -> {
            ErrorDialogCustom(
                title = stringResource(Res.string.warning),
                message = (loginUiEvent as LoginUiEvent.ShowErrorDialog).message,
                buttonText = stringResource(Res.string.accept),
                onConfirm = viewModel::resetUiEvent,
            )
        }
        is LoginUiEvent.LoginSuccess -> onLoginSuccess()
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun LoginScreenPreview() {
    SafeScreenContainerTest {
        LoginScreen()
    }
}
