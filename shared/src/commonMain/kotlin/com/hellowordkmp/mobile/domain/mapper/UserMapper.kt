/*
 * UserMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.domain.mapper

import com.hellowordkmp.mobile.data.network.model.UserResponse
import com.hellowordkmp.mobile.domain.model.UserModel

fun UserResponse.toDomain(): UserModel =
    UserModel(
        id = id,
        name = name,
        imageUrl = imageUrl,
    )
