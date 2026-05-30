/*
 * InsetUsersUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.usecase

import com.myalbum2026.core.domain.model.UserModel
import com.myalbum2026.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class InsetUsersUseCase(
    private val repository: UserRepository,
) {

    suspend operator fun invoke(users: List<UserModel>): Flow<List<Long>> =
        repository.insertUsers(users = users)
}
