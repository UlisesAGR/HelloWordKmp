/*
 * UserRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.domain.repository

import com.hellowordkmp.mobile.domain.model.UserModel
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
