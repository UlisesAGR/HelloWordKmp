/*
 * UsersLocalDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.local.datasource

import com.hellowordkmp.mobile.data.local.model.UsersEntity
import kotlinx.coroutines.flow.Flow

interface UsersLocalDataSource {
    suspend fun insertUser(user: UsersEntity): Long
    fun getAllUsers(): Flow<List<UsersEntity>>
    suspend fun getUserById(id: Int): UsersEntity?
    suspend fun deleteUser(user: UsersEntity)
}
