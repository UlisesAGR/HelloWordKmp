/*
 * GetUserTokenUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.domain.usecase

import com.hellowordkmp.mobile.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserTokenUseCase(
    private val repository: UserRepository,
) {

    suspend operator fun invoke(): Flow<String?> =
        repository.getUserToken()
}
