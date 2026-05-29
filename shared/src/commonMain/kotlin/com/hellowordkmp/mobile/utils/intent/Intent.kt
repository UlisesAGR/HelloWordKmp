/*
 * Intent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.utils.intent

expect fun openUrl(
    url: String,
    onSuccess: () -> Unit,
    onError: () -> Unit,
)
