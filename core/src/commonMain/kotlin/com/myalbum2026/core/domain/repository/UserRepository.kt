/*
 * UserRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.repository

import com.myalbum2026.core.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    // Remote
    suspend fun getUsers(url: String): Flow<List<UserModel>>

    // Local
    suspend fun insertUsers(users: List<UserModel>): Flow<List<Long>>
    suspend fun getAllUsers(): Flow<List<UserModel>>

    // Data source
    suspend fun getUserToken(): Flow<String?>
    suspend fun saveUserToken(token: String): Flow<Unit>
}
