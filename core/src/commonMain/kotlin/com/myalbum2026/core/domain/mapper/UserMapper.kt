/*
 * UserMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.mapper

import com.myalbum2026.core.data.local.model.UserEntity
import com.myalbum2026.core.data.network.model.UserResponse
import com.myalbum2026.core.domain.model.UserModel

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
