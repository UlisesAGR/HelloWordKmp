/*
 * UsersLocalDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.local.datasource

import com.hellowordkmp.mobile.data.local.dao.UsersDao
import com.hellowordkmp.mobile.data.local.datastore.AppDataStore
import com.hellowordkmp.mobile.domain.mapper.toDomain
import com.hellowordkmp.mobile.domain.mapper.toEntity
import com.hellowordkmp.mobile.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

class UsersLocalDataSourceImpl(
    private val usersDao: UsersDao,
    private val dataStore: AppDataStore,
) : UsersLocalDataSource {

    override suspend fun insertUser(user: UserModel): Long =
        usersDao.insertUser(user = user.toEntity())

    override suspend fun getAllUsers(): List<UserModel> =
        usersDao.getAllUsers().map { data -> data.toDomain() }

    override suspend fun getUserById(id: Int): UserModel? =
        usersDao.getUserById(id = id)?.toDomain()

    override suspend fun deleteUser(user: UserModel) =
        usersDao.deleteUser(user = user.toEntity())

    override suspend fun getUserToken(): Flow<String?> =
        dataStore.userToken

    override suspend fun saveUserToken(token: String) =
        dataStore.saveToken(token = token)
}
