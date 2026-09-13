package com.dev.groomi.auth.register

import com.dev.groomi.auth.dto.login.LoginRequest
import com.dev.groomi.auth.dto.register.RegisterRequest
import com.dev.groomi.auth.dto.register.RegisterResponse
import com.dev.groomi.auth.login.test_utils.LoginActions
import com.dev.groomi.auth.login.test_utils.LoginTestSetup
import com.dev.groomi.auth.login.test_utils.createLoginTestSetup
import com.dev.groomi.auth.register.test_utils.RegisterTestSetup
import com.dev.groomi.auth.register.test_utils.createRegisterTestSetup
import com.dev.groomi.auth.repository.login.LoginResult
import com.dev.groomi.auth.repository.register.RegisterResult
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.verify

class RegisterRepositoryTest {
    private lateinit var registerSetup: RegisterTestSetup
    @Before
    fun givenRegisterRepository() {
        registerSetup = createRegisterTestSetup()
    }
    @Test
    fun successfulRegisterAttempt(): Unit = runTest {
        LoginActions.givenSuccessfulLogin(registerSetup.api)
        val whenOurResult = registerSetup.repository.register(
            "jimmie",
            "smith",
            "777-777-7777",
            "jsmith@test.com",
            "testPass123",
            "testPass123"
        )
        Assert.assertTrue(whenOurResult is RegisterResult.Success)
        verify(registerSetup.api)
            .register(
                RegisterRequest(
                    "jimmie",
                    "smith",
                    "jsmith@test.com",
                    "777-777-7777",
                    "testPass123"
                )
            )
    }
}