package com.dev.groomi.auth.repository.register

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

sealed interface RegisterResult{
    data object Success: RegisterResult
    data class  Failure(val message: String): RegisterResult
}

class FakeRegisterRepository : RegisterRepositoryInterface {

    override suspend fun register(
        firstName: String,
        lastName: String,
        phoneNumber: String,
        email: String,
        password: String,
        confirmPassword: String
    ): RegisterResult{
        delay(2000.milliseconds)
        return RegisterResult.Success
        //TODO implement for future real repo
        // return RegisterResult.Failure
    }
}