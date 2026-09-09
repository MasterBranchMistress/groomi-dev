package com.dev.groomi.auth.repository.change_password

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.change_password.ChangePasswordRequest
import jakarta.inject.Inject

sealed interface ChangePasswordResult{
    data object Success: ChangePasswordResult
    data class Failure(val message: String): ChangePasswordResult
}

class ChangePasswordRepository @Inject constructor(private val api: AuthenticationApi): ChangePasswordRepositoryInterface{
    override suspend fun changePassword(token: String?, password: String): ChangePasswordResult {
        return try {
            api.changePassword(ChangePasswordRequest(token =token, newPassword = password))
            ChangePasswordResult.Success
        } catch(e: Exception){
            ChangePasswordResult.Failure(message = e.message.toString())
        }
    }

}