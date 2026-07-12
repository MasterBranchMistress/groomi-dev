package com.dev.groomi.auth.validation.validators

import com.dev.groomi.auth.validation.fields.AuthenticationFields
import com.dev.groomi.shared.validation.ValidationResult

object AuthenticationValidator {

    fun validateLogin(
        email: String,
        password: String
    ): ValidationResult<AuthenticationFields> {

        if (email.isBlank()) {
            return ValidationResult.Error(AuthenticationFields.EMAIL,
                "Email is required.")
        }

        if (password.isBlank()) {
            return ValidationResult.Error(AuthenticationFields.PASSWORD,
                "Password is required")
        }

        if (password.length < 6) {
            return ValidationResult.Error(AuthenticationFields.PASSWORD,
                "Password must be at least 6 characters")
        }

        return ValidationResult.Success
    }
}