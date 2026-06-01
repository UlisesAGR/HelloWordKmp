/*
 * UsersLocalDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.local.datasource

import com.myalbum2026.core.domain.model.user.UserModel
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
