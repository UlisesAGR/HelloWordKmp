/*
 * Platform.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.utils.device

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
