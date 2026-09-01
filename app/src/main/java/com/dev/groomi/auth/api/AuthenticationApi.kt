package com.dev.groomi.auth.api

import com.dev.groomi.auth.dto.change_password.ChangePasswordRequest
import com.dev.groomi.auth.dto.change_password.ChangePasswordResponse
import com.dev.groomi.auth.dto.forgot_password.ForgotPasswordRequest
import com.dev.groomi.auth.dto.forgot_password.ForgotPasswordResponse
import com.dev.groomi.auth.dto.login.LoginRequest
import com.dev.groomi.auth.dto.login.LoginResponse
import com.dev.groomi.auth.dto.logout.LogoutResponse
import com.dev.groomi.auth.dto.register.RegisterRequest
import com.dev.groomi.auth.dto.register.RegisterResponse
import com.dev.groomi.auth.dto.reset_password.ResetPasswordRequest
import com.dev.groomi.auth.dto.reset_password.ResetPasswordResponse
import com.dev.groomi.shared.network.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthenticationApi {

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): ApiResponse<LoginResponse>

    @POST("auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): ApiResponse<RegisterResponse>

    @POST("auth/logout")
    suspend fun logout(): ApiResponse<LogoutResponse>

    @POST("auth/forgot-password")
    suspend fun submitEmail(
        @Body request: ForgotPasswordRequest
    ): ApiResponse<ForgotPasswordResponse>

    @POST("auth/verify-password-reset-link")
    suspend fun resetPassword(
        @Body request: ResetPasswordRequest
    ): ApiResponse<ResetPasswordResponse>

    @POST("auth/change-password")
    suspend fun changePassword(
        @Body request: ChangePasswordRequest
    ): ApiResponse<ChangePasswordResponse>
}

