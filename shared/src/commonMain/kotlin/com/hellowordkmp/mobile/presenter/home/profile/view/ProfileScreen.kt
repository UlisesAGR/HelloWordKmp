/*
 * ProfileScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.profile.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hellowordkmp.mobile.presenter.components.DialogCustom
import com.hellowordkmp.mobile.presenter.components.ErrorDialogCustom
import com.hellowordkmp.mobile.presenter.components.LoadingCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.hellowordkmp.mobile.presenter.home.profile.viewmodel.ProfileUiEvent
import com.hellowordkmp.mobile.presenter.home.profile.viewmodel.ProfileViewModel
import com.hellowordkmp.mobile.utils.intent.openUrl
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.accept
import hellowordkmp.shared.generated.resources.cancel
import hellowordkmp.shared.generated.resources.error_try_open_navigator_web
import hellowordkmp.shared.generated.resources.idle
import hellowordkmp.shared.generated.resources.info
import hellowordkmp.shared.generated.resources.warning
import hellowordkmp.shared.generated.resources.you_will_exit_the_application
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = koinViewModel(),
    onLogout: () -> Unit = {},
) {
    val homeUiState by viewModel.profileUiState.collectAsStateWithLifecycle()
    val homeUiEvent by viewModel.profileUiEvent.collectAsStateWithLifecycle()

    ProfileContent(
        onLogout = onLogout,
        onShowDialog = {
            viewModel.showInfoDialog()
        },
    )

    if (homeUiState.isLoading) {
        LoadingCustom()
    }

    when (homeUiEvent) {
        is ProfileUiEvent.Idle -> print(stringResource(Res.string.idle))
        is ProfileUiEvent.ShowInfoDialog -> {
            DialogCustom(
                title = stringResource(Res.string.info),
                message = stringResource(Res.string.you_will_exit_the_application),
                buttonTextConfirm = stringResource(Res.string.accept),
                buttonTextDismiss = stringResource(Res.string.cancel),
                onConfirm = {
                    openUrl(
                        url = "www.google.com",
                        onSuccess = {
                            viewModel.resetUiEvent()
                        },
                        onError = {
                            viewModel.showErrorDialog()
                        },
                    )
                },
                onDismiss = {
                    viewModel.resetUiEvent()
                },
            )
        }
        is ProfileUiEvent.ShowErrorDialog -> {
            ErrorDialogCustom(
                title = stringResource(Res.string.warning),
                message = stringResource(Res.string.error_try_open_navigator_web),
                buttonText = stringResource(Res.string.accept),
                onConfirm = {
                    viewModel.resetUiEvent()
                },
            )
        }
    }
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
