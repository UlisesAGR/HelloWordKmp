/*
 * WebViewScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.webview.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hellowordkmp.mobile.presenter.components.ErrorDialogCustom
import com.hellowordkmp.mobile.presenter.components.LoadingCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.hellowordkmp.mobile.presenter.components.SafeScreenScaffoldContainer
import com.hellowordkmp.mobile.presenter.webview.viewmodel.WebViewViewModel
import com.hellowordkmp.mobile.presenter.webview.viewmodel.WebviewUiEvent
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.accept
import hellowordkmp.shared.generated.resources.error_load_webview
import hellowordkmp.shared.generated.resources.idle
import hellowordkmp.shared.generated.resources.warning
import hellowordkmp.shared.generated.resources.web_view
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun WebViewScreen(
    viewModel: WebViewViewModel = koinViewModel(),
    onBack: () -> Unit = {},
) {
    val webViewUiState by viewModel.webViewUiState.collectAsStateWithLifecycle()
    val webviewUiEvent by viewModel.webviewUiEvent.collectAsStateWithLifecycle()

    SafeScreenScaffoldContainer(
        title = stringResource(Res.string.web_view),
        icon = Icons.AutoMirrored.Filled.ArrowBack,
        onBack = onBack,
        content = {
            webViewUiState.webViewState?.let { webViewState ->

                WebViewContent(state = webViewState)

                if (webViewState.isLoading) {
                    LoadingCustom()
                }

                if (webViewState.errorsForCurrentRequest.isNotEmpty()) {
                    viewModel.showErrorDialog()
                }
            }

            when (webviewUiEvent) {
                is WebviewUiEvent.Idle -> print(stringResource(Res.string.idle))
                is WebviewUiEvent.ShowErrorDialog -> {
                    ErrorDialogCustom(
                        title = stringResource(Res.string.warning),
                        message = stringResource(Res.string.error_load_webview),
                        buttonText = stringResource(Res.string.accept),
                        onConfirm = viewModel::resetUiEvent,
                    )
                }
            }
        },
    )
}

@Preview(
    showBackground = true,
)
@Composable
private fun WebViewScreenPreview() {
    SafeScreenContainerTest {
        WebViewScreen()
    }
}
