package com.dev.groomi.auth.repository.login

import android.util.Log
import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.login.LoginRequest
import com.dev.groomi.shared.local.auth.TokenManager
import com.dev.groomi.shared.utils.parseErrorMessage
import retrofit2.HttpException
import javax.inject.Inject

class LoginRepository @Inject constructor (private val api: AuthenticationApi, private val tokenManager: TokenManager): LoginRepositoryInterface{
    override suspend fun login(email: String, password: String): LoginResult {
        return try {
           val response = api.login(
                LoginRequest(
                    email = email,
                    password = password
                )
            )
            tokenManager.saveToken(response.data.token)
            LoginResult.Success
        } catch (error: HttpException) {
            val errorResponse = parseErrorMessage(error)
            Log.d("LOGIN_ERROR", errorResponse)
            LoginResult.Failure(
                errorResponse
            )
        }
    }
}