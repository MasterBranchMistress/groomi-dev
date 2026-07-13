package com.dev.groomi.auth.api

import com.dev.groomi.auth.dto.login.LoginRequest
import com.dev.groomi.auth.dto.login.LoginResponse
import com.dev.groomi.auth.dto.logout.LogoutResponse
import com.dev.groomi.auth.dto.register.RegisterRequest
import com.dev.groomi.auth.dto.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @POST("auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse

    @POST("auth/logout")
    suspend fun  logout() : LogoutResponse
}

