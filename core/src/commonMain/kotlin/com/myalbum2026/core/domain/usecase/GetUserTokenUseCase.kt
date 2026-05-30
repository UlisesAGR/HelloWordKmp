/*
 * GetUserTokenUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.usecase

import com.myalbum2026.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserTokenUseCase(
    private val repository: UserRepository,
) {

    suspend operator fun invoke(): Flow<String?> =
        repository.getUserToken()
}
