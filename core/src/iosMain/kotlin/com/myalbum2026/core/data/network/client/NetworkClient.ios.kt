/*
 * NetworkClient.ios.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.network.client

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

actual fun createHttpClient(): HttpClient = HttpClient(Darwin) {

    install(HttpTimeout) {
        requestTimeoutMillis = 15000
        connectTimeoutMillis = 10000
        socketTimeoutMillis = 10000
    }

    install(Logging) {
        level = LogLevel.BODY
        logger = object : Logger {
            override fun log(message: String) {
                println("Ktor_iOS_Log: $message")
            }
        }
    }

    install(ContentNegotiation) {
        json(
            json = Json { ignoreUnknownKeys = true },
            contentType = ContentType.Any,
        )
    }

    defaultRequest {
        url(NetworkClient.BASE_URL)
    }
}
