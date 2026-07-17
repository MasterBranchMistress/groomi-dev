package com.dev.groomi.auth.repository.login

import android.util.Log
import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.login.LoginRequest
import javax.inject.Inject
class LoginRepository @Inject constructor (private val api: AuthenticationApi): LoginRepositoryInterface{
    override suspend fun login(email: String, password: String): LoginResult {
        return try {
                val response = api.login(
                    LoginRequest(
                        email = email,
                        password = password
                    )
                )
            // TODO: save JWT later
            Log.d("LOGIN", response.message)
            LoginResult.Success
        } catch (error: Exception) {
            error.message?.let { Log.d("LOGIN", it) }
            LoginResult.Failure(
                error.message ?: "Login failed"
            )
        }
    }
}