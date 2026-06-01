/*
 * LoginResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.network.model.response.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val status: Int?,
    val message: String?,
)
