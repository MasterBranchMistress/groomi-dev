package com.dev.groomi.auth.repository.forgotPassword

interface ForgotPasswordRepositoryInterface {
    suspend fun submitEmail(
        email: String
    ): ForgotPasswordResult
}