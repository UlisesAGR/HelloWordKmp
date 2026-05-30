/*
 * SaveUserTokenUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.usecase

import com.myalbum2026.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class SaveUserTokenUseCase(
    private val repository: UserRepository,
) {

    suspend operator fun invoke(token: String): Flow<Unit> =
        repository.saveUserToken(token = token)
}
