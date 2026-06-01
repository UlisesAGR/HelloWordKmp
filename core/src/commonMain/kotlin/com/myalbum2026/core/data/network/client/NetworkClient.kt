/*
 * NetworkClient.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.network.client

import io.ktor.client.HttpClient

expect fun createHttpClient(): HttpClient

object NetworkClient {
    const val BASE_URL = "https://hellowordkmp.free.beeceptor.com/"
    const val LOGIN_ENDPOINT = "login"
    const val USERS_ENDPOINT = "userList"
}
