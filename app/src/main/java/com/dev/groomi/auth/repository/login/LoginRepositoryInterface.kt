package com.dev.groomi.auth.repository.login

interface LoginRepositoryInterface {

    suspend fun login(
        email: String,
        password: String
    ): LoginResult
}