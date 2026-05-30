/*
 * UserRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.repository

import com.myalbum2026.core.data.local.datasource.UsersLocalDataSource
import com.myalbum2026.core.data.network.datasource.UserRemoteDataSource
import com.myalbum2026.core.domain.model.UserModel
import com.myalbum2026.core.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val usersLocalDataSource: UsersLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher,
) : UserRepository {

    // Remote
    override suspend fun getUsers(url: String): Flow<List<UserModel>> = flow {
        emit(userRemoteDataSource.fetchUsers(url))
    }.flowOn(ioDispatcher)

    // Local
    override suspend fun insertUsers(users: List<UserModel>): Flow<List<Long>> = flow {
        emit(usersLocalDataSource.insertUsers(users = users))
    }.flowOn(ioDispatcher)

    override suspend fun getAllUsers(): Flow<List<UserModel>> = flow {
        emit(usersLocalDataSource.getAllUsers())
    }.flowOn(ioDispatcher)

    // Data source
    override suspend fun getUserToken(): Flow<String?> =
        usersLocalDataSource.getUserToken()

    override suspend fun saveUserToken(token: String): Flow<Unit> = flow {
        emit(usersLocalDataSource.saveUserToken(token = token))
    }.flowOn(ioDispatcher)
}
