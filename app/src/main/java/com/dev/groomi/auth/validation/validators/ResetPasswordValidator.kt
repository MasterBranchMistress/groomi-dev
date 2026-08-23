package com.dev.groomi.auth.validation.validators

import com.dev.groomi.auth.validation.fields.ResetPasswordFields
import com.dev.groomi.shared.validation.ValidationResult

object ResetPasswordValidator {

    fun validate(
        password: String,
        confirmPassword: String
    ): ValidationResult<ResetPasswordFields> {

        if (password.isBlank()) {
            return ValidationResult.Error(
                ResetPasswordFields.PASSWORD,
                "Password is required."
            )
        }

        if (password.length < 8) {
            return ValidationResult.Error(
                ResetPasswordFields.PASSWORD,
                "Password must be at least 8 characters."
            )
        }

        if (confirmPassword.isBlank()) {
            return ValidationResult.Error(
                ResetPasswordFields.CONFIRM_PASSWORD,
                "Please confirm your password."
            )
        }

        if (password != confirmPassword) {
            return ValidationResult.Error(
                ResetPasswordFields.CONFIRM_PASSWORD,
                "Passwords do not match."
            )
        }

        return ValidationResult.Success
    }
}