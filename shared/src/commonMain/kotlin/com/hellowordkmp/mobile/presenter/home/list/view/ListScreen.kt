/*
 * ListScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.list.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hellowordkmp.mobile.presenter.components.EmptyStateWifiCustom
import com.hellowordkmp.mobile.presenter.components.ErrorDialogCustom
import com.hellowordkmp.mobile.presenter.components.LoadingCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.hellowordkmp.mobile.presenter.home.list.viewmodel.HomeUiEvent
import com.hellowordkmp.mobile.presenter.home.list.viewmodel.ListViewModel
import com.hellowordkmp.mobile.utils.animation.Animation
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.accept
import hellowordkmp.shared.generated.resources.empty_list
import hellowordkmp.shared.generated.resources.idle
import hellowordkmp.shared.generated.resources.please_try_again_later
import hellowordkmp.shared.generated.resources.reload
import hellowordkmp.shared.generated.resources.warning
import hellowordkmp.shared.generated.resources.you_dont_have_users
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ListScreen(
    viewModel: ListViewModel = koinViewModel(),
) {
    val homeUiState by viewModel.listUiState.collectAsStateWithLifecycle()
    val homeUiEvent by viewModel.listUiEvent.collectAsStateWithLifecycle()

    AnimatedContent(
        targetState = homeUiState,
        transitionSpec = { Animation.scaleTransition() },
    ) { currentState ->

        currentState.list?.takeIf { list -> list.isNotEmpty() }?.let { users ->
            ListContent(users = users)
        } ?: run {
            EmptyStateWifiCustom(
                isConnected = homeUiState.isConnected,
                icon = Icons.AutoMirrored.Filled.List,
                title = stringResource(Res.string.empty_list),
                description = stringResource(Res.string.you_dont_have_users),
                buttonText = stringResource(Res.string.reload),
                onButtonClick = viewModel::retryGetUsers,
            )
        }

        if (currentState.isLoading) {
            LoadingCustom()
        }
    }

    when (homeUiEvent) {
        is HomeUiEvent.Idle -> print(stringResource(Res.string.idle))
        is HomeUiEvent.ShowErrorDialog -> {
            ErrorDialogCustom(
                title = stringResource(Res.string.warning),
                message = stringResource(Res.string.please_try_again_later),
                buttonText = stringResource(Res.string.accept),
                onConfirm = viewModel::resetUiEvent,
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
