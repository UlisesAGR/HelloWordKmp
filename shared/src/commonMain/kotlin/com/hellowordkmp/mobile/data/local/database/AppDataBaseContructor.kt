/*
 * AppDataBaseContructor.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.local.database

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}
