package com.dev.groomi.auth.repository.forgotPassword

sealed interface ForgotPasswordResult{
    data object Success: ForgotPasswordResult
    data object Failure: ForgotPasswordResult
}