package com.hellowordkmp.mobile.utils.device

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
