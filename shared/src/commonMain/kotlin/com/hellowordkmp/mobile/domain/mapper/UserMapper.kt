/*
 * UserMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.domain.mapper

import com.hellowordkmp.mobile.data.local.model.UserEntity
import com.hellowordkmp.mobile.data.network.model.UserResponse
import com.hellowordkmp.mobile.domain.model.UserModel

fun UserResponse.toDomain(): UserModel =
    UserModel(
        id = id ?: 0,
        name = name.orEmpty(),
        email = email.orEmpty(),
    )

fun UserEntity.toDomain(): UserModel =
    UserModel(
        id = id,
        name = name.orEmpty(),
        email = email.orEmpty(),
    )

fun UserModel.toEntity(): UserEntity =
    UserEntity(
        id = id,
        name = name,
        email = email,
    )
