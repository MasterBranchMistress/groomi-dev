package com.dev.groomi.auth.repository.reset_password

interface VerifyPasswordResetTokenRepositoryInterface {
        suspend fun verifyResetPasswordToken(
                token: String?
        ): VerifyResetPasswordTokenResult
}