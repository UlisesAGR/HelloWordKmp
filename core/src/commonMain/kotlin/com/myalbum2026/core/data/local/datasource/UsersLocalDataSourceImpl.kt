/*
 * UsersLocalDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.local.datasource

import com.myalbum2026.core.data.local.dao.UsersDao
import com.myalbum2026.core.data.local.datastore.AppDataStore
import com.myalbum2026.core.domain.mapper.toDomain
import com.myalbum2026.core.domain.mapper.toEntity
import com.myalbum2026.core.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

class UsersLocalDataSourceImpl(
    private val usersDao: UsersDao,
    private val dataStore: AppDataStore,
) : UsersLocalDataSource {

    override suspend fun insertUsers(users: List<UserModel>): List<Long> =
        usersDao.insertUsers(users = users.map { data -> data.toEntity() })

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
