package com.dev.groomi.auth.repository.login

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.login.LoginRequest


class LoginRepository(private val api: AuthenticationApi): LoginRepositoryInterface{
    override suspend fun login(email: String, password: String): LoginResult {
        return try {

            val response = api.login(
                LoginRequest(
                    email = email,
                    password = password
                )
            )

            // TODO: save JWT later

            LoginResult.Success

        } catch (e: Exception) {

            LoginResult.Failure(
                e.message ?: "Login failed"
            )
        }
    }
}