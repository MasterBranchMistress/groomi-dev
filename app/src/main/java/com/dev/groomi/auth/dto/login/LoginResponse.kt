package com.dev.groomi.auth.dto.login

import java.util.UUID

data class LoginResponse(
    val userId: UUID,
    val email: String,
    val message: String,
)
