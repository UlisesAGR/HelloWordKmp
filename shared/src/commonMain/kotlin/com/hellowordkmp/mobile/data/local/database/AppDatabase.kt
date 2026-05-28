/*
 * AppDatabase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hellowordkmp.mobile.data.local.dao.UsersDao
import com.hellowordkmp.mobile.data.local.model.UserEntity

expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>

@Database(
    entities = [
        UserEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {
        const val DATABASE_NAME = "hellowordkmp_database.db"
        // Migrations
//        val MIGRATION_1_2: Migration = object : Migration(1,2) {
//            override fun migrate(connection: SQLiteConnection) {
//                super.migrate(connection)
//                connection.execSQL("CREATE TABLE users_admin")
//            }
//        }
    }
}
