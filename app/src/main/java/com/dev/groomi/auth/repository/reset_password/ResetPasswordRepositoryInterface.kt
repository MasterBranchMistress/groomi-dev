package com.dev.groomi.auth.repository.reset_password

interface ResetPasswordRepositoryInterface {
        suspend fun resetPassword(
                token: String?,
                password: String
        ): ResetPasswordResult
}