package com.dev.groomi.auth.repository.login

interface AuthRepositoryInterface {

    suspend fun login(
        email: String,
        password: String
    ): LoginResult
}