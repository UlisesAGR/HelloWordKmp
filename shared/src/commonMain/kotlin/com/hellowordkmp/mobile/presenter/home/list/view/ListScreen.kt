/*
 * ListScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.list.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hellowordkmp.mobile.presenter.components.ErrorDialogCustom
import com.hellowordkmp.mobile.presenter.components.LoadingCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.hellowordkmp.mobile.presenter.home.list.viewmodel.HomeUiEvent
import com.hellowordkmp.mobile.presenter.home.list.viewmodel.ListViewModel
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.accept
import hellowordkmp.shared.generated.resources.idle
import hellowordkmp.shared.generated.resources.warning
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ListScreen(
    viewModel: ListViewModel = koinViewModel(),
    username: String = "",
) {
    val homeUiState by viewModel.listUiState.collectAsStateWithLifecycle()
    val homeUiEvent by viewModel.listUiEvent.collectAsStateWithLifecycle()

    ListContent(
        username = username,
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

@Preview(
    showBackground = true,
)
@Composable
private fun ListScreenPreview() {
    SafeScreenContainerTest {
        ListScreen()
    }
}
