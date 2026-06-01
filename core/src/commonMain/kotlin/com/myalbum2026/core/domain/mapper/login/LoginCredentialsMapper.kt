/*
 * LoginCredentialsMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.mapper.login

import com.myalbum2026.core.data.network.model.request.LoginCredentialsRequest
import com.myalbum2026.core.domain.model.login.LoginCredentialsModel

fun LoginCredentialsModel.toRequest(): LoginCredentialsRequest =
    LoginCredentialsRequest(
        email = email,
        password = password,
    )
