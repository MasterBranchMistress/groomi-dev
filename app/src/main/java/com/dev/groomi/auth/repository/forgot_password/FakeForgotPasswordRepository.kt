package com.dev.groomi.auth.repository.forgot_password

sealed interface ForgotPasswordResult{
    data object Success: ForgotPasswordResult
    data object Failure: ForgotPasswordResult
}