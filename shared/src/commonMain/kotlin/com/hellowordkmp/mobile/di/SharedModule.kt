/*
 * CoreModule.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.di

import com.hellowordkmp.mobile.presenter.home.list.viewmodel.ListViewModel
import com.hellowordkmp.mobile.presenter.home.profile.viewmodel.ProfileViewModel
import com.hellowordkmp.mobile.presenter.webview.viewmodel.WebViewViewModel
import com.hellowordkmp.mobile.utils.connection.getConnectivityProvider
import com.myalbum2026.core.di.dataModule
import com.myalbum2026.core.di.dataStoreModule
import com.myalbum2026.core.di.databaseModule
import com.myalbum2026.core.di.dispatcherModule
import com.myalbum2026.core.di.domainModule
import com.myalbum2026.core.di.networkModule
import com.myalbum2026.core.di.repositoryModule
import dev.jordond.connectivity.Connectivity
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val connectivityModule = module {
    single { getConnectivityProvider() }
    single<Connectivity> {
        Connectivity(provider = get())
    }
}

val viewmodelModule = module {
    viewModelOf(::ListViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::WebViewViewModel)
}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            connectivityModule,
            dispatcherModule,
            dataStoreModule,
            databaseModule,
            networkModule,
            dataModule,
            repositoryModule,
            domainModule,
            viewmodelModule,
        )
    }
}
