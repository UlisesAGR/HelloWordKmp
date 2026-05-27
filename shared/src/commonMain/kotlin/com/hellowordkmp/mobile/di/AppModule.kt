/*
 * AppModule.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.di

import com.hellowordkmp.mobile.data.network.client.createHttpClient
import com.hellowordkmp.mobile.data.network.datasource.UserRemoteDataSource
import com.hellowordkmp.mobile.data.network.datasource.UserRemoteDataSourceImpl
import com.hellowordkmp.mobile.data.network.repository.UserRepositoryImpl
import com.hellowordkmp.mobile.domain.repository.UserRepository
import com.hellowordkmp.mobile.domain.usecase.GetUsersUseCase
import com.hellowordkmp.mobile.presenter.home.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

val dispatcherModule = module {
    single<CoroutineDispatcher> { Dispatchers.IO }
}

val networkModule = module {
    single { createHttpClient() }
}

val dataModule = module {
    singleOf(::UserRemoteDataSourceImpl) bind UserRemoteDataSource::class
}

val repositoryModule = module {
    singleOf(::UserRepositoryImpl) bind UserRepository::class
}

val domainModule = module {
    factoryOf(::GetUsersUseCase)
}

val presentationModule = module {
    viewModelOf(::HomeViewModel)
}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
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
