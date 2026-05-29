/*
 * AppDatabase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.hellowordkmp.mobile.data.local.dao.UsersDao
import com.hellowordkmp.mobile.data.local.model.UserEntity

@Database(
    entities = [
        UserEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {
        const val DATABASE_NAME = "hellowordkmp_database.db"
    }
}

expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>
