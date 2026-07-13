package com.dev.groomi.auth.repository.logout

sealed interface LogoutResult{
    data object Success: LogoutResult
    data object Failure: LogoutResult
}

class FakeLogoutRepository : LogoutRepositoryInterface {
    override suspend fun logout(
        userId: String,
        session: Boolean
    ): LogoutResult {
        return LogoutResult.Success
        //TODO: implement logout failures
    }
}