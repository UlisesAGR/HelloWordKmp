/*
 * ListContent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.home.list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.domain.model.UserModel
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainer
import com.hellowordkmp.mobile.presenter.components.TextBigBoldCustom
import com.hellowordkmp.mobile.presenter.components.TextSmallCustom
import com.hellowordkmp.mobile.presenter.components.items.UserItem
import com.hellowordkmp.mobile.utils.values.Dimens
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.hello
import hellowordkmp.shared.generated.resources.navigate_to_home_successful
import org.jetbrains.compose.resources.stringResource

@Composable
fun ListContent(
    users: List<UserModel> = emptyList(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = Dimens.padding8,
                vertical = Dimens.padding32,
            ),
        verticalArrangement = Arrangement.Top,
    ) {
        TextBigBoldCustom(
            text = stringResource(Res.string.hello),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(Dimens.padding8))
        TextSmallCustom(
            text = stringResource(Res.string.navigate_to_home_successful),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(Dimens.padding32))
        LazyColumn {
            items(
                items = users,
                key = { user -> user.id },
            ) { user ->
                UserItem(user)
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun ListContentPreview() {
    SafeScreenContainer {
        ListContent(
            users = listOf(
                UserModel(
                    id = 0,
                    name = "Example",
                    email = "example@gmail.com",
                ),
                UserModel(
                    id = 1,
                    name = "Example",
                    email = "example@gmail.com",
                ),
            )
        )
    }
}
