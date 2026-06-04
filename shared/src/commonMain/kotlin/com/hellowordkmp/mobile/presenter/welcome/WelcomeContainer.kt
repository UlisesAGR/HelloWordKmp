/*
 * WelcomeContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hellowordkmp.mobile.presenter.components.ButtonPrimaryCustom
import com.hellowordkmp.mobile.presenter.components.SafeScreenContainerTest
import com.hellowordkmp.mobile.presenter.components.TextBigBoldCustom
import com.hellowordkmp.mobile.presenter.components.TextMediumCustom
import com.hellowordkmp.mobile.utils.values.Dimens
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import hellowordkmp.shared.generated.resources.Res
import hellowordkmp.shared.generated.resources.explore_our_multiplatform_platform
import hellowordkmp.shared.generated.resources.login
import hellowordkmp.shared.generated.resources.placeholder
import hellowordkmp.shared.generated.resources.welcome_app
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun WelcomeContainer(
    onNavigateToLogin: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .size(150.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(size = 10.dp)),
            imageModel = {"https://miro.medium.com/1*DH2pe-b0-898YDap6ReV8Q.png"},
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            ),
            loading = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(50.dp))
                }
            },
            failure = {
                Image(
                    painter = painterResource(Res.drawable.placeholder),
                    contentDescription = "Error al cargar imagen"
                )
            }
        )
        TextBigBoldCustom(
            text = stringResource(Res.string.welcome_app),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(Dimens.padding16))
        TextMediumCustom(
            text = stringResource(Res.string.explore_our_multiplatform_platform),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(Dimens.height32))
        ButtonPrimaryCustom(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
            text = stringResource(Res.string.login),
            onClick = onNavigateToLogin,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeContainerPreview() {
    SafeScreenContainerTest {
        WelcomeContainer()
    }
}
