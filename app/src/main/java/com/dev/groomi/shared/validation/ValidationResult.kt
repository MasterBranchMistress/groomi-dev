package com.dev.groomi.shared.validation

sealed class ValidationResult{
    data object Success: ValidationResult()
    data class Error(val field: ValidationField, val message: String): ValidationResult()
}

enum class ValidationField {
    EMAIL,
    PASSWORD
}