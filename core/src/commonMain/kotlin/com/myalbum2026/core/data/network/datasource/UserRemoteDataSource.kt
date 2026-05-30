/*
 * UserRemoteDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.network.datasource

import com.myalbum2026.core.domain.model.UserModel

interface UserRemoteDataSource {
    suspend fun fetchUsers(url: String): List<UserModel>
}
