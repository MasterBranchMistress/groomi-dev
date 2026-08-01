package com.dev.groomi.auth.repository.forgot_password

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.forgot_password.ForgotPasswordRequest
import javax.inject.Inject

class ForgotPasswordRepository @Inject constructor(
     private val api: AuthenticationApi
) : ForgotPasswordRepositoryInterface {
    override suspend fun submitEmail(
        email: String
    ): ForgotPasswordResult {
        return try {
            api.submitEmail(
                ForgotPasswordRequest(
                    email = email,
                )
            )
            ForgotPasswordResult.Success
        } catch(error: Exception){
            ForgotPasswordResult.Failure
        }
    }
}