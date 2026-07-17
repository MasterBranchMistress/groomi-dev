package com.dev.groomi.auth.repository.logout

import android.util.Log
import com.dev.groomi.auth.api.AuthenticationApi
import retrofit2.HttpException
import javax.inject.Inject

class LogoutRepository @Inject constructor(private val api: AuthenticationApi): LogoutRepositoryInterface{
    override suspend fun logout(): LogoutResult {
        return try {
            //TODO: clear tokens and whatever else
            api.logout()
            LogoutResult.Success
        } catch (error: HttpException) {
            LogoutResult.Failure("Logout Failed")
        }
    }
}