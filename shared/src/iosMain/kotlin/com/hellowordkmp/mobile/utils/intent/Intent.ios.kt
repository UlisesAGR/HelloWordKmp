/*
 * Intent.ios.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.utils.intent

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual fun openUrl(
    url: String,
    onSuccess: () -> Unit,
    onError: () -> Unit,
) {
    val nsUrl = NSURL.URLWithString(url) ?: return
    val application = UIApplication.sharedApplication
    if (application.canOpenURL(nsUrl)) {
        application.openURL(nsUrl, options = emptyMap<Any?, Any?>()) { success ->
            if (success) {
                onSuccess()
            } else {
                onError()
            }
        }
    }
}
