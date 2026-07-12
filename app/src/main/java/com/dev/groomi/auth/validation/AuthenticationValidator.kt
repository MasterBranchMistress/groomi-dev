package com.dev.groomi.auth.validation

import com.dev.groomi.shared.validation.ValidationField
import com.dev.groomi.shared.validation.ValidationResult

object AuthenticationValidator {

    fun validateLogin(
        email: String,
        password: String
    ): ValidationResult {

        if (email.isBlank()) {
            return ValidationResult.Error(ValidationField.EMAIL,
                "Email is required.")
        }

        if (password.isBlank()) {
            return ValidationResult.Error(ValidationField.PASSWORD,
                "Password is required")
        }

        if (password.length < 6) {
            return ValidationResult.Error(ValidationField.PASSWORD,
                "Password must be at least 6 characters")
        }

        return ValidationResult.Success
    }
}