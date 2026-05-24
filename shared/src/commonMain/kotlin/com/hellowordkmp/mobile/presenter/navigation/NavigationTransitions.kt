package com.hellowordkmp.mobile.presenter.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

private const val DURATION = 300

val enterTransition = { fadeIn(animationSpec = tween(DURATION)) }
val exitTransition = { fadeOut(animationSpec = tween(DURATION)) }
val popEnterTransition = { fadeIn(animationSpec = tween(DURATION)) }
val popExitTransition = { fadeOut(animationSpec = tween(DURATION)) }
