/*
 * UserRemoteDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.network.datasource

import com.myalbum2026.core.data.network.model.response.login.LoginResponse
import com.myalbum2026.core.data.network.model.response.user.UserResponse
import com.myalbum2026.core.domain.mapper.login.toDomain
import com.myalbum2026.core.domain.mapper.login.toRequest
import com.myalbum2026.core.domain.mapper.user.toDomain
import com.myalbum2026.core.domain.model.login.LoginCredentialsModel
import com.myalbum2026.core.domain.model.login.LoginModel
import com.myalbum2026.core.domain.model.user.UserModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class UserRemoteDataSourceImpl(
    private val httpClient: HttpClient
) : UserRemoteDataSource {

    override suspend fun login(
        url: String,
        loginCredentials: LoginCredentialsModel,
    ): LoginModel =
        httpClient
            .post(urlString = url) {
                contentType(ContentType.Application.Json)
                setBody(loginCredentials.toRequest())
            }
            .body<LoginResponse>()
            .toDomain()

    override suspend fun fetchUsers(url: String): List<UserModel> =
        httpClient
            .get(urlString = url)
            .body<List<UserResponse>>()
            .map { data -> data.toDomain() }
}
