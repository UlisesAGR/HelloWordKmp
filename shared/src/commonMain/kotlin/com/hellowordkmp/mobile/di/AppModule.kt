/*
 * AppModule.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.hellowordkmp.mobile.data.local.dao.UsersDao
import com.hellowordkmp.mobile.data.local.database.AppDatabase
import com.hellowordkmp.mobile.data.local.database.getDatabaseBuilder
import com.hellowordkmp.mobile.data.local.datasource.UsersLocalDataSource
import com.hellowordkmp.mobile.data.local.datasource.UsersLocalDataSourceImpl
import com.hellowordkmp.mobile.data.local.datastore.AppDataStore
import com.hellowordkmp.mobile.data.local.datastore.createDataStore
import com.hellowordkmp.mobile.data.network.client.createHttpClient
import com.hellowordkmp.mobile.data.network.datasource.UserRemoteDataSource
import com.hellowordkmp.mobile.data.network.datasource.UserRemoteDataSourceImpl
import com.hellowordkmp.mobile.data.repository.UserRepositoryImpl
import com.hellowordkmp.mobile.domain.repository.UserRepository
import com.hellowordkmp.mobile.domain.usecase.GetUsersUseCase
import com.hellowordkmp.mobile.presenter.home.list.viewmodel.ListViewModel
import com.hellowordkmp.mobile.presenter.home.profile.viewmodel.ProfileViewModel
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

val dataStoreModule = module {
    single<DataStore<Preferences>> { createDataStore() }
    singleOf(::AppDataStore)
}

val databaseModule = module {
    single<AppDatabase> {
        getDatabaseBuilder()
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
    single<UsersDao> { get<AppDatabase>().usersDao() }
}

val networkModule = module {
    single { createHttpClient() }
}

val dataModule = module {
    singleOf(::UserRemoteDataSourceImpl) bind UserRemoteDataSource::class
    singleOf(::UsersLocalDataSourceImpl) bind UsersLocalDataSource::class
}

val repositoryModule = module {
    singleOf(::UserRepositoryImpl) bind UserRepository::class
}

val domainModule = module {
    factoryOf(::GetUsersUseCase)
}

val presentationModule = module {
    viewModelOf(::ListViewModel)
    viewModelOf(::ProfileViewModel)
}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            dispatcherModule,
            dataStoreModule,
            databaseModule,
            networkModule,
            dataModule,
            repositoryModule,
            domainModule,
            presentationModule,
        )
    }
}
