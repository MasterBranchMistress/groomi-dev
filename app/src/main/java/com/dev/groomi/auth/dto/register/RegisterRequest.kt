package com.dev.groomi.auth.dto.register

data class RegisterRequest(val firstName: String,
                           val lastName: String,
                           val email: String,
                           val phoneNumber: String,
                           val password: String
    )