/*
 * ValidationResult.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.myalbum2026.core.domain.utils

sealed class ValidationResult {
    data object EmailEmpty : ValidationResult()
    data object PasswordEmpty : ValidationResult()
    data object ValidationSuccess : ValidationResult()
}
