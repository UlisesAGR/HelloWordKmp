/*
 * UserRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.domain.repository

import com.hellowordkmp.mobile.data.local.model.UsersEntity
import com.hellowordkmp.mobile.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    // Remote
    suspend fun getUsers(url: String): Flow<List<UserModel>>
    // Local
    suspend fun insertUser(user: UsersEntity): Long
}
