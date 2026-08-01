package com.dev.groomi.auth.repository.pending_reset_link

sealed interface ResendResetLinkResult{
    data object Success: ResendResetLinkResult
    data object Failure: ResendResetLinkResult
}