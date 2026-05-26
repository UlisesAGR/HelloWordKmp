/*
 * UserRemoteDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.network.datasource

import com.hellowordkmp.mobile.domain.model.UserModel

interface UserRemoteDataSource {
    suspend fun fetchUsers(url: String): List<UserModel>
}
