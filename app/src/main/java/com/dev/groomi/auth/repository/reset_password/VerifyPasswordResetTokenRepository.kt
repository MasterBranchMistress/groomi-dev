package com.dev.groomi.auth.repository.reset_password

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.verify_reset_password_token.VerifyResetPasswordTokenRequest
import jakarta.inject.Inject

sealed interface VerifyResetPasswordTokenResult{
    data object Success: VerifyResetPasswordTokenResult
    data class Failure(val message: String): VerifyResetPasswordTokenResult
}

class VerifyPasswordResetTokenRepository @Inject constructor(
    private val api: AuthenticationApi
) : VerifyPasswordResetTokenRepositoryInterface {

    override suspend fun verifyResetPasswordToken(
        token: String
    ): VerifyResetPasswordTokenResult {
        return try {
            api.verifyResetPasswordToken(token)
            VerifyResetPasswordTokenResult.Success
        } catch (e: Exception) {
            VerifyResetPasswordTokenResult.Failure(
                message = e.message.toString()
            )
        }
    }

}