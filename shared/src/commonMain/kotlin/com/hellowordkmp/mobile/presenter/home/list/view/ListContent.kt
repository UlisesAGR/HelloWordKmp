/*
 * ListContent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainer
import com.hellowordkmp.mobile.presenter.components.TextBigCustom
import com.hellowordkmp.mobile.presenter.components.TextSmallCustom
import com.hellowordkmp.mobile.utils.values.Dimens
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.hello_user
import hellowordkmp.shared.generated.resources.navigate_to_home_successful
import org.jetbrains.compose.resources.stringResource

@Composable
fun ListContent(
    username: String = "",
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Dimens.padding16),
        verticalArrangement = Arrangement.Center,
    ) {
        TextBigCustom(text = stringResource(Res.string.hello_user, username))
        Spacer(modifier = Modifier.height(Dimens.padding8))
        TextSmallCustom(text = stringResource(Res.string.navigate_to_home_successful))
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun ListContentPreview() {
    SafeScreenContainer {
        ListContent()
    }
}
