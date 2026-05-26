/*
 * UserRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.domain.repository

import com.hellowordkmp.mobile.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsers(url: String): Flow<List<UserModel>>
}
