package com.dev.groomi.auth.login.test_utils

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.login.LoginResponse
import com.dev.groomi.auth.repository.login.FakeLoginRepository
import com.dev.groomi.auth.repository.login.LoginRepositoryInterface
import com.dev.groomi.auth.repository.login.LoginResult
import com.dev.groomi.shared.network.ApiResponse
import com.dev.groomi.test_utils.auth.AuthFixtures
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.mockito.kotlin.wheneverBlocking
import retrofit2.HttpException
import retrofit2.Response
import kotlin.time.Duration.Companion.milliseconds

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
    fun givenPendingLogin(repository: LoginRepositoryInterface) = runTest {
        whenever(repository.login(any(), any()))
            .thenAnswer {
                runBlocking {
                    delay(2000.milliseconds)
                    LoginResult.Success
                }
            }
    }
}