package com.dev.groomi.auth.repository.login

import android.util.Log
import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.login.LoginRequest
import com.dev.groomi.shared.utils.parseErrorMessage
import retrofit2.HttpException
import javax.inject.Inject

class LoginRepository @Inject constructor (private val api: AuthenticationApi): LoginRepositoryInterface{
    override suspend fun login(email: String, password: String): LoginResult {
        return try {
           api.login(
                LoginRequest(
                    email = email,
                    password = password
                )
            )
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