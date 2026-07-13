package com.dev.groomi.auth.repository.register

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

interface RegisterRepositoryInterface {
    suspend fun register(
        firstName: String,
        lastName: String,
        phoneNumber: String,
        email: String,
        password: String,
        confirmPassword: String,
    ): RegisterResult
}