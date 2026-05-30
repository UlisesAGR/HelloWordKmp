/*
 * UserItem.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.components.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainer
import com.hellowordkmp.mobile.presenter.components.TextMediumBoldCustom
import com.hellowordkmp.mobile.utils.values.Dimens
import com.myalbum2026.core.domain.model.UserModel
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.email_arg
import hellowordkmp.shared.generated.resources.name_arg
import org.jetbrains.compose.resources.stringResource

@Composable
fun UserItem(user: UserModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.padding8),
    ) {
        Column(
            modifier = Modifier
                .padding(Dimens.padding16),
        ) {
            TextMediumBoldCustom(
                text = stringResource(Res.string.name_arg, user.name),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
            )
            Spacer(modifier = Modifier.height(Dimens.padding8))
            TextMediumBoldCustom(
                text = stringResource(Res.string.email_arg, user.email),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun UserItemPreview() {
    SafeScreenContainer {
        UserItem(
            user = UserModel(
                id = 0,
                name = "Example",
                email = "example@gmail.com",
            )
        )
    }
}
