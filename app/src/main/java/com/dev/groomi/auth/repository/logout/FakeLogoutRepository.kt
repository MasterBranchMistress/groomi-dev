package com.dev.groomi.auth.repository.logout

sealed interface LogoutResult{
    data object Success: LogoutResult
    data class Failure(val message: String): LogoutResult
}

class FakeLogoutRepository : LogoutRepositoryInterface {
    override suspend fun logout(): LogoutResult {
        return LogoutResult.Success
        //TODO: implement logout failures
    }
}