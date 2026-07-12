package com.dev.groomi.auth.validation.validators

import com.dev.groomi.auth.validation.fields.RegistrationFields
import com.dev.groomi.shared.validation.ValidationResult

object RegistrationValidator{
    fun validateRegistration(
        firstName: String,
        lastName:String,
        email:String,
        phoneNumber: String,
        password: String,
        confirmPassword: String
    ): ValidationResult<RegistrationFields>{
        if(firstName.isBlank()) return ValidationResult.Error(RegistrationFields.FIRST_NAME,"First name is required.")
        if(lastName.isBlank()) return ValidationResult.Error(RegistrationFields.LAST_NAME,"Last name is required.")
        if(email.isBlank()) return ValidationResult.Error(RegistrationFields.EMAIL,"Email is required.")
        if(phoneNumber.isBlank()) return ValidationResult.Error(RegistrationFields.PHONE_NUMBER,"Phone is required.")
        if(password.isBlank()) return ValidationResult.Error(RegistrationFields.PASSWORD,"Password is required.")
        if(password.length < 6) return ValidationResult.Error(RegistrationFields.PASSWORD,"Password must be at least 6 characters.")
        if(password != confirmPassword) return ValidationResult.Error(RegistrationFields.PASSWORD,"Passwords must match.")
        return ValidationResult.Success
    }
}
