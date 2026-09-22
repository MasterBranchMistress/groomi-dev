package com.dev.groomi.auth.repository.account_verification

interface PendingAccountVerificationRepositoryInterface {

    suspend fun verifyAccount(
        token: String
    ): PendingAccountVerificationResult
}