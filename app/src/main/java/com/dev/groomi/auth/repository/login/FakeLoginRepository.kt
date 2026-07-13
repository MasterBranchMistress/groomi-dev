package com.dev.groomi.auth.repository.login

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

sealed interface LoginResult{
    data object Success: LoginResult
    data object Failure: LoginResult
}

class FakeAuthenticationRepository : LoginRepositoryInterface {

    override suspend fun login(
        email: String,
        password: String
    ): LoginResult {
        delay(2000.milliseconds)
     return LoginResult.Success
        //TODO implement for future real repo
        // return LoginResult.Failure
    }
}