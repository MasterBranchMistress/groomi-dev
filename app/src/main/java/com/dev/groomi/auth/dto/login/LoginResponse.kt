package com.dev.groomi.auth.dto.login

data class LoginResponse(
    val userId: String,
    val email: String,
    val token: String
)
