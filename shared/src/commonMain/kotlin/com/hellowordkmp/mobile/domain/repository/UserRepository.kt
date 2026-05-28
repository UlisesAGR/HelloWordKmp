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
    suspend fun insertUser(user: UserModel): Flow<Long>
    suspend fun getUserToken(): Flow<String?>
    suspend fun saveUserToken(token: String): Flow<Unit>
}
