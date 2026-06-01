/*
 * UserEntity.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String?,
    val email: String?,
    val token: String?,
)
