package com.dev.groomi.auth.repository.reset_password

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.reset_password.ResetPasswordRequest
import jakarta.inject.Inject

sealed interface ResetPasswordResult{
    data object Success: ResetPasswordResult
    data class Failure(val message: String): ResetPasswordResult
}

class ResetPasswordRepository @Inject constructor(private val api: AuthenticationApi): ResetPasswordRepositoryInterface{
    override suspend fun resetPassword(
        password: String,
    ): ResetPasswordResult {
       return try {
           api.resetPassword(ResetPasswordRequest(password))
           ResetPasswordResult.Success
       } catch(e: Exception){
           ResetPasswordResult.Failure(message = e.message.toString())
       }
    }
}