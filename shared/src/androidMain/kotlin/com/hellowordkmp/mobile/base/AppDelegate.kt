/*
 * AppDelegate.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.base

import android.app.Application
import com.hellowordkmp.mobile.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class AppDelegate : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AppDelegate)
        }
    }
}
