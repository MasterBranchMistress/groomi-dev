package com.dev.groomi.auth.repository.reset_password

interface ResetPasswordRepositoryInterface {
        suspend fun resetPassword(password: String): ResetPasswordResult
}