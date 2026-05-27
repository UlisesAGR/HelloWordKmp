/*
 * HomeScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hellowordkmp.mobile.presenter.components.ErrorDialogCustom
import com.hellowordkmp.mobile.presenter.components.LoadingCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainer
import com.hellowordkmp.mobile.presenter.home.viewmodel.HomeUiEvent
import com.hellowordkmp.mobile.presenter.home.viewmodel.HomeViewModel
import com.hellowordkmp.mobile.theme.AppTheme
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.accept
import hellowordkmp.shared.generated.resources.idle
import hellowordkmp.shared.generated.resources.warning
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    username: String,
    onLogout: () -> Unit,
) {
    val homeUiState by viewModel.homeUiState.collectAsStateWithLifecycle()
    val homeUiEvent by viewModel.homeUiEvent.collectAsStateWithLifecycle()

    SafeScreenContainer {

        HomeContent(
            username = username,
            onLogout = onLogout,
        )

        if (homeUiState.isLoading) {
            LoadingCustom()
        }

        when (homeUiEvent) {
            is HomeUiEvent.Idle -> print(stringResource(Res.string.idle))
            is HomeUiEvent.ShowError -> {
                ErrorDialogCustom(
                    title = stringResource(Res.string.warning),
                    message = (homeUiEvent as HomeUiEvent.ShowError).exception,
                    buttonText = stringResource(Res.string.accept),
                    onDismiss = {
                        viewModel.resetUiEvent()
                    },
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun LoginScreenPreview() {
    AppTheme {
        SafeScreenContainer {
            HomeScreen(
                username = "",
                onLogout = {},
            )
        }
    }
}
