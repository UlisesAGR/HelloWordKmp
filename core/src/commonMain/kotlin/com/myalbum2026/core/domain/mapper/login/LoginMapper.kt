/*
 * LoginMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.mapper.login

import com.myalbum2026.core.data.network.model.response.login.LoginResponse
import com.myalbum2026.core.domain.model.login.LoginModel

fun LoginResponse.toDomain(): LoginModel =
    LoginModel(
        status = status ?: 0,
        message = message.orEmpty(),
    )
