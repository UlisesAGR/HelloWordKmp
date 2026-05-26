/*
 * GetUsersUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.domain.usecase

import com.hellowordkmp.mobile.domain.model.UserModel
import com.hellowordkmp.mobile.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(
    private val repository: UserRepository,
) {

    suspend operator fun invoke(url: String): Flow<List<UserModel>> =
        repository.getUsers(url)
}
