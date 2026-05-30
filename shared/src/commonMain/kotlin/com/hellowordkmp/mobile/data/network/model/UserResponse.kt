/*
 * UserResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: Int?,
    val name: String?,
    val email: String?,
)
