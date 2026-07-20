package com.dev.groomi.test_utils.auth

import com.dev.groomi.auth.dto.login.LoginResponse

object AuthFixtures {
    fun validLoginResponse(
        token: String = "fake-jwt-token",
    ) = LoginResponse(
        userId = "test-user-id",
        email = "test@example.com",
        token = token
    )
    fun invalidLoginResponse() = LoginResponse(userId = "invalid-user", email = "invalid@test.com", token = "invalid-token")

}