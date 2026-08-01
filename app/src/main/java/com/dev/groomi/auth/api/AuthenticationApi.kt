package com.dev.groomi.auth.api

import com.dev.groomi.auth.dto.forgot_password.ForgotPasswordRequest
import com.dev.groomi.auth.dto.forgot_password.ForgotPasswordResponse
import com.dev.groomi.auth.dto.login.LoginRequest
import com.dev.groomi.auth.dto.login.LoginResponse
import com.dev.groomi.auth.dto.logout.LogoutResponse
import com.dev.groomi.auth.dto.register.RegisterRequest
import com.dev.groomi.auth.dto.register.RegisterResponse
import com.dev.groomi.auth.dto.resend_reset_link.ResendResetLinkRequest
import com.dev.groomi.auth.dto.resend_reset_link.ResendResetLinkResponse
import com.dev.groomi.auth.repository.pending_reset_link.ResendResetLinkResult
import com.dev.groomi.shared.network.ApiResponse
import retrofit2.http.Body
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

    @POST("auth/resend-reset-link")
    suspend fun resendResetLink(
        @Body request: ResendResetLinkRequest
    ): ApiResponse<ResendResetLinkResponse>
}

