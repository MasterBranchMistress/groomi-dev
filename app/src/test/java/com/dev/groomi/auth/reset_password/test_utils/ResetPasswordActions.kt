package com.dev.groomi.auth.reset_password.test_utils

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.change_password.ChangePasswordResponse
import com.dev.groomi.shared.network.ApiResponse
import com.dev.groomi.test_utils.auth.AuthFixtures
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import retrofit2.HttpException
import retrofit2.Response

object ResetPasswordActions {

    fun givenSuccessfulResetPassword(api: AuthenticationApi): Unit = runTest {
        whenever(api.changePassword(any()))
            .thenReturn(
                ApiResponse<ChangePasswordResponse>(
                    message = "password change successfully",
                    data = AuthFixtures.validResetPasswordResponse(),
                    timestamp = ""
            )
        )
    }
}