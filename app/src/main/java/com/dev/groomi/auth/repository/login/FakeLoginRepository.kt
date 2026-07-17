package com.dev.groomi.auth.repository.login

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

sealed interface LoginResult{

    data object Success: LoginResult
    data class Failure(val message: String): LoginResult
}

class FakeLoginRepository : LoginRepositoryInterface {

    override suspend fun login(
        email: String,
        password: String
    ): LoginResult {
        delay(2000.milliseconds)
     return LoginResult.Success
    }
}