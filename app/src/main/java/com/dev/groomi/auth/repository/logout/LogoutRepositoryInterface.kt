package com.dev.groomi.auth.repository.logout

interface LogoutRepositoryInterface {

    suspend fun logout(): LogoutResult
}