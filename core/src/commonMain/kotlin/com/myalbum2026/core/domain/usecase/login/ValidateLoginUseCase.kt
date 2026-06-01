/*
 * ValidateLoginUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.usecase.login

import com.myalbum2026.core.domain.utils.ValidationResult

class ValidateLoginUseCase {

    operator fun invoke(
        email: String,
        password: String,
    ): ValidationResult =
        when {
            email.isEmpty() -> ValidationResult.EmailEmpty
            password.isEmpty() -> ValidationResult.PasswordEmpty
            else -> ValidationResult.ValidationSuccess
        }
}
