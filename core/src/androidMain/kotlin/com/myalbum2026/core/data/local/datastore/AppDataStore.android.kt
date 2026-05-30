/*
 * AppDataStore.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath
import org.koin.mp.KoinPlatform.getKoin

actual fun createDataStore(): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath(
        produceFile = {
            val context: Context = getKoin().get()
            context.filesDir.resolve("${AppDataStore.DATASTORE_NAME}.preferences_pb").absolutePath.toPath()
        },
    )
