package com.dev.groomi.auth.repository.logout

interface LogoutRepositoryInterface {

    suspend fun logout(
       userId: String,
       session: Boolean
    ): LogoutResult
}