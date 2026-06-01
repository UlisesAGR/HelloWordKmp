/*
 * LoginUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.usecase.login

import com.myalbum2026.core.domain.model.login.LoginCredentialsModel
import com.myalbum2026.core.domain.model.login.LoginModel
import com.myalbum2026.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val repository: UserRepository,
) {

    suspend operator fun invoke(
        url: String,
        email: String,
        password: String,
    ): Flow<LoginModel> = repository.login(
        url = url,
        loginCredentials = LoginCredentialsModel(
            email = email,
            password = password,
        ),
    )
}
