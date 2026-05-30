/*
 * CoreModule.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.myalbum2026.core.data.local.dao.UsersDao
import com.myalbum2026.core.data.local.database.AppDatabase
import com.myalbum2026.core.data.local.database.getDatabaseBuilder
import com.myalbum2026.core.data.local.datasource.UsersLocalDataSource
import com.myalbum2026.core.data.local.datasource.UsersLocalDataSourceImpl
import com.myalbum2026.core.data.local.datastore.AppDataStore
import com.myalbum2026.core.data.local.datastore.createDataStore
import com.myalbum2026.core.data.network.client.createHttpClient
import com.myalbum2026.core.data.network.datasource.UserRemoteDataSource
import com.myalbum2026.core.data.network.datasource.UserRemoteDataSourceImpl
import com.myalbum2026.core.data.repository.UserRepositoryImpl
import com.myalbum2026.core.domain.repository.UserRepository
import com.myalbum2026.core.domain.usecase.GetAllUsersUseCase
import com.myalbum2026.core.domain.usecase.GetUserTokenUseCase
import com.myalbum2026.core.domain.usecase.GetUsersUseCase
import com.myalbum2026.core.domain.usecase.InsetUsersUseCase
import com.myalbum2026.core.domain.usecase.SaveUserTokenUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
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
    factoryOf(::InsetUsersUseCase)
    factoryOf(::GetAllUsersUseCase)
    factoryOf(::GetUserTokenUseCase)
    factoryOf(::SaveUserTokenUseCase)
}
