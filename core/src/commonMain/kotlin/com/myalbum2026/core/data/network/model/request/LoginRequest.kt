/*
 * LoginCredentialsRequest.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.network.model.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginCredentialsRequest(
    val email: String,
    val password: String,
)
