/*
 * InsetUsersUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.domain.usecase

import com.hellowordkmp.mobile.domain.model.UserModel
import com.hellowordkmp.mobile.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class InsetUsersUseCase(
    private val repository: UserRepository,
) {

    suspend operator fun invoke(users: List<UserModel>): Flow<List<Long>> =
        repository.insertUsers(users = users)
}
