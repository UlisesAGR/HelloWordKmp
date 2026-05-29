/*
 * Intent.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.utils.intent

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import org.koin.mp.KoinPlatform.getKoin

actual fun openUrl(
    url: String,
    onSuccess: () -> Unit,
    onError: () -> Unit,
) {
    val context = getKoin().get<Context>()
    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    if (intent.resolveActivity(context.packageManager) != null) {
        onSuccess()
        context.startActivity(intent)
    } else {
        onError()
    }
}
