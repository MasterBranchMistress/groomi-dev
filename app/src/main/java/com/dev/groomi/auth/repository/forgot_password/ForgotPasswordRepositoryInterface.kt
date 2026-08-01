package com.dev.groomi.auth.repository.forgot_password

interface ForgotPasswordRepositoryInterface {
    suspend fun submitEmail(
        email: String
    ): ForgotPasswordResult
}