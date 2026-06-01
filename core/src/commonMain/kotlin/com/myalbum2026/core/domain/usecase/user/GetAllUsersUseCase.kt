/*
 * GetAllUsersUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.usecase.user

import com.myalbum2026.core.domain.model.user.UserModel
import com.myalbum2026.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetAllUsersUseCase(
    private val repository: UserRepository,
) {

    suspend operator fun invoke(): Flow<List<UserModel>> =
        repository.getAllUsers()
}
