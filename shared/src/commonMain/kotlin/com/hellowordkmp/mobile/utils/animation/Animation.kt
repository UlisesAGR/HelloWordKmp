/*
 * Animation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.utils.animation

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith

object Animation {

    private const val DEFAULT_DURATION = 400

    fun scaleTransition(): ContentTransform =
        scaleIn(
            initialScale = 0.9f,
            animationSpec = tween(durationMillis = DEFAULT_DURATION, easing = FastOutSlowInEasing),
        ) + fadeIn() togetherWith scaleOut(
            targetScale = 1.1f,
            animationSpec = tween(durationMillis = DEFAULT_DURATION, easing = FastOutSlowInEasing),
        ) + fadeOut()
}
