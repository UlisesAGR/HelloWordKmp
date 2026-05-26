/*
 * AppDelegate.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.base

import android.app.Application
import com.hellowordkmp.mobile.di.dataModule
import com.hellowordkmp.mobile.di.dispatcherModule
import com.hellowordkmp.mobile.di.domainModule
import com.hellowordkmp.mobile.di.networkModule
import com.hellowordkmp.mobile.di.presentationModule
import com.hellowordkmp.mobile.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AppDelegate : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppDelegate)
            modules(
                dispatcherModule,
                networkModule,
                dataModule,
                repositoryModule,
                domainModule,
                presentationModule,
            )
        }
    }
}
