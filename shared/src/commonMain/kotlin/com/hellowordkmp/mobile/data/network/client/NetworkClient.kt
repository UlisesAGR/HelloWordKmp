/*
 * NetworkClient.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.network.client

import io.ktor.client.HttpClient

expect fun createHttpClient(): HttpClient

object NetworkClient {
    const val BASE_URL = "https://hellowordkmp.free.beeceptor.com/"
    const val USERS_ENDPOINT = "userList"
}
