package com.dev.groomi.auth.login.test_utils

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.login.LoginResponse
import com.dev.groomi.shared.network.ApiResponse
import com.dev.groomi.test_utils.auth.AuthFixtures
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import retrofit2.HttpException
import retrofit2.Response

object LoginActions {

    fun givenSuccessfulLogin(api: AuthenticationApi): Unit = runTest{
        whenever(api.login(any()))
            .thenReturn(
                ApiResponse(
                    message = "Login Successful",
                    data = AuthFixtures.validLoginResponse(),
                    timestamp = ""
                )
            )
    }
    fun givenInvalidCredentials(api: AuthenticationApi): Unit =  runTest {
        whenever(api.login(any()))
            .thenThrow(
                HttpException(
                    Response.error<ApiResponse<LoginResponse>>(
                        401,
                        "".toResponseBody()
                    )
                )
            )
    }
     fun givenServerError(api: AuthenticationApi): Unit =  runTest {
        whenever(api.login(any()))
            .thenThrow(
                HttpException(
                    Response.error<ApiResponse<LoginResponse>>(
                        500,
                        "".toResponseBody()
                    )
                )
            )
    }
}