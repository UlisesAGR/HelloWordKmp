/*
 * UserRemoteDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.network.datasource

import com.myalbum2026.core.domain.model.login.LoginCredentialsModel
import com.myalbum2026.core.domain.model.login.LoginModel
import com.myalbum2026.core.domain.model.user.UserModel

interface UserRemoteDataSource {
    suspend fun login(
        url: String,
        loginCredentials: LoginCredentialsModel,
    ): LoginModel
    suspend fun fetchUsers(url: String): List<UserModel>
}
