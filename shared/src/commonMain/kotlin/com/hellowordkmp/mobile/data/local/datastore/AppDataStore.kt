/*
 * AppDataStore.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.io.IOException

class AppDataStore(private val dataStore: DataStore<Preferences>) {

    companion object  {
        const val DATASTORE_NAME = "hellowordkmp_settings"
    }

    private object Keys {
        val USER_TOKEN = stringPreferencesKey("user_token")
    }

    val userToken: Flow<String?> = dataStore.data
        .catch { exception ->
            if (exception is IOException) emit(emptyPreferences()) else throw exception
        }.map { data -> data[Keys.USER_TOKEN] }

    suspend fun saveToken(token: String) {
        dataStore.edit { data -> data[Keys.USER_TOKEN] = token }
    }
}

expect fun createDataStore(): DataStore<Preferences>
