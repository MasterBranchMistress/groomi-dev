package com.dev.groomi.auth.repository.register

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