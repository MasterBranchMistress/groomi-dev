package com.dev.groomi.shared.validation

sealed class ValidationResult<out T>{
    data object Success: ValidationResult<Nothing>()
    data class Error<T>(
        val field: T,
        val message: String
    ) : ValidationResult<T>()
}