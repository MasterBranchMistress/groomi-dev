package com.dev.groomi.auth.repository.pending_reset_link

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

interface PendingResetLinkRepositoryInterface {
    suspend fun resendResetLink(email: String): ResendResetLinkResult {
        delay(3000.milliseconds)
        return ResendResetLinkResult.Success
    }
}