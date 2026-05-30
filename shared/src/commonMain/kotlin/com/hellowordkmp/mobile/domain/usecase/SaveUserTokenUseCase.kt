/*
 * SaveUserTokenUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.domain.usecase

import com.hellowordkmp.mobile.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class SaveUserTokenUseCase(
    private val repository: UserRepository,
) {

    suspend operator fun invoke(token: String): Flow<Unit> =
        repository.saveUserToken(token = token)
}
