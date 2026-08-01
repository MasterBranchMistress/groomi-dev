package com.dev.groomi.auth.repository.pending_reset_link

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.resend_reset_link.ResendResetLinkRequest
import javax.inject.Inject

class PendingResetLinkRepository @Inject constructor(
    private val api: AuthenticationApi
) : PendingResetLinkRepositoryInterface {
    override suspend fun resendResetLink(email: String): ResendResetLinkResult {
            api.resendResetLink(ResendResetLinkRequest(email))
            return ResendResetLinkResult.Success
    }
}