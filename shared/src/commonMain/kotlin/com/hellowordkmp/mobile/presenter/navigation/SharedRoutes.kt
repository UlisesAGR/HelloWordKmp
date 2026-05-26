/*
 * SharedRoutes.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.navigation

import kotlinx.serialization.Serializable

@Serializable
object WelcomeRoute

@Serializable
object LoginRoute

@Serializable
data class HomeRoute(val username: String)
