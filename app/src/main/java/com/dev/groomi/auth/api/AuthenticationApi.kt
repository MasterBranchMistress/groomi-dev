package com.dev.groomi.auth.api

import androidx.media3.exoplayer.drm.ExoMediaDrm
import com.dev.groomi.auth.dto.change_password.ChangePasswordRequest
import com.dev.groomi.auth.dto.change_password.ChangePasswordResponse
import com.dev.groomi.auth.dto.forgot_password.ForgotPasswordRequest
import com.dev.groomi.auth.dto.forgot_password.ForgotPasswordResponse
import com.dev.groomi.auth.dto.login.LoginRequest
import com.dev.groomi.auth.dto.login.LoginResponse
import com.dev.groomi.auth.dto.logout.LogoutResponse
import com.dev.groomi.auth.dto.register.RegisterRequest
import com.dev.groomi.auth.dto.register.RegisterResponse
import com.dev.groomi.auth.dto.verify_reset_password_token.VerifyResetPasswordTokenRequest
import com.dev.groomi.auth.dto.verify_reset_password_token.VerifyResetPasswordTokenResponse
import com.dev.groomi.shared.network.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

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

    @GET("auth/verify-reset-password-token")
    suspend fun verifyResetPasswordToken(
        @Query("token") token: String
    ): ApiResponse<VerifyResetPasswordTokenResponse>

    @POST("auth/change-password")
    suspend fun changePassword(
        @Body request: ChangePasswordRequest
    ): ApiResponse<ChangePasswordResponse>
}

