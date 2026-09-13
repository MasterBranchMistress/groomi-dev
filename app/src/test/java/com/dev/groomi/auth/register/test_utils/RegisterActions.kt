package com.dev.groomi.auth.register.test_utils

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.shared.network.ApiResponse
import com.dev.groomi.test_utils.auth.AuthFixtures
import kotlinx.coroutines.test.runTest
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

object RegisterActions {
    fun givenSuccessfulRegister(api: AuthenticationApi): Unit = runTest{
        whenever(api.register(any()))
            .thenReturn(
                ApiResponse(
                    message = "Registration Successful",
                    data = AuthFixtures.validRegisterResponse(),
                    timestamp = ""
                )
            )
    }
}