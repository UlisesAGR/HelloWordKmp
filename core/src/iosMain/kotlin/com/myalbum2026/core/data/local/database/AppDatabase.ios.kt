/*
 * AppDatabase.ios.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.local.database

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual fun getDatabaseBuilder() : RoomDatabase.Builder<AppDatabase>{
    return Room.databaseBuilder<AppDatabase>(
        name = documentDirectory() + "/${AppDatabase.DATABASE_NAME}",
    ).setDriver(androidx.sqlite.driver.bundled.BundledSQLiteDriver())
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}
