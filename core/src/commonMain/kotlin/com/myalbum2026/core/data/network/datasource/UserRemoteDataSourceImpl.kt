/*
 * UserRemoteDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.network.datasource

import com.myalbum2026.core.data.network.model.UserResponse
import com.myalbum2026.core.domain.mapper.toDomain
import com.myalbum2026.core.domain.model.UserModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserRemoteDataSourceImpl(
    private val httpClient: HttpClient
): UserRemoteDataSource {

    override suspend fun fetchUsers(url: String): List<UserModel> =
        httpClient
            .get(urlString = url)
            .body<List<UserResponse>>()
            .map { data -> data.toDomain() }
}
