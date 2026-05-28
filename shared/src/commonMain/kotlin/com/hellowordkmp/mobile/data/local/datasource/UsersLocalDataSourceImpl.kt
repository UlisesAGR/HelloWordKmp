/*
 * UsersLocalDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.local.datasource

import com.hellowordkmp.mobile.data.local.dao.UsersDao
import com.hellowordkmp.mobile.data.local.model.UsersEntity
import kotlinx.coroutines.flow.Flow

class UsersLocalDataSourceImpl(
    private val usersDao: UsersDao
) : UsersLocalDataSource {

    override suspend fun insertUser(user: UsersEntity): Long =
        usersDao.insertUser(user = user)

    override fun getAllUsers(): Flow<List<UsersEntity>> =
        getAllUsers()

    override suspend fun getUserById(id: Int): UsersEntity? =
        usersDao.getUserById(id = id)

    override suspend fun deleteUser(user: UsersEntity) =
        usersDao.deleteUser(user = user)
}
