/*
 * UsersLocalDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.local.datasource

import com.hellowordkmp.mobile.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UsersLocalDataSource {
    // Local
    suspend fun insertUsers(users: List<UserModel>): List<Long>
    suspend fun getAllUsers(): List<UserModel>
    suspend fun getUserById(id: Int): UserModel?
    suspend fun deleteUser(user: UserModel)

    // Data source
    suspend fun getUserToken(): Flow<String?>
    suspend fun saveUserToken(token: String)
}
