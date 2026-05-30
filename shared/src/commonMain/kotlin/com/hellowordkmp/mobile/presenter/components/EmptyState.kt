package com.hellowordkmp.mobile.presenter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.hellowordkmp.mobile.utils.values.Dimens

@Composable
fun EmptyStateCustom(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    description: String,
    buttonText: String? = null,
    onButtonClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(Dimens.padding32),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(Dimens.height64),
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        TextBigBoldCustom(
            text = title,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        TextMediumCustom(
            text = description,
            modifier = Modifier.fillMaxWidth(),
        )
        if (buttonText != null) {
            Spacer(modifier = Modifier.height(Dimens.height32))
            ButtonPrimaryCustom(
                text = buttonText,
                onClick = onButtonClick,
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun EmptyStatePreview() {
    SafeScreenContainerTest {
        EmptyStateCustom(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            title = "Example",
            description = "Example",
            buttonText = "Example",
        )
    }
}
