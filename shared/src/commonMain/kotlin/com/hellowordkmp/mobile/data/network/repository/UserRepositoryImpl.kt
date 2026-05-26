/*
 * UserRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.network.repository

import com.hellowordkmp.mobile.data.network.datasource.UserRemoteDataSource
import com.hellowordkmp.mobile.domain.model.UserModel
import com.hellowordkmp.mobile.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher,
) : UserRepository {

    override suspend fun getUsers(url: String): Flow<List<UserModel>> = flow {
        emit(remoteDataSource.fetchUsers(url))
    }.flowOn(ioDispatcher)
}
