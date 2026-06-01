/*
 * UserMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.mapper.user

import com.myalbum2026.core.data.local.model.UserEntity
import com.myalbum2026.core.data.network.model.response.user.UserResponse
import com.myalbum2026.core.domain.model.user.UserModel

fun UserResponse.toDomain(): UserModel =
    UserModel(
        id = id ?: 0,
        name = name.orEmpty(),
        email = email.orEmpty(),
        token = token.orEmpty(),
    )

fun UserEntity.toDomain(): UserModel =
    UserModel(
        id = id,
        name = name.orEmpty(),
        email = email.orEmpty(),
        token = token.orEmpty(),
    )

fun UserModel.toEntity(): UserEntity =
    UserEntity(
        id = id,
        name = name,
        email = email,
        token = token,
    )
