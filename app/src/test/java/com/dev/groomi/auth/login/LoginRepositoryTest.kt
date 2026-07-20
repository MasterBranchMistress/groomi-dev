package com.dev.groomi.auth.login

import com.dev.groomi.auth.dto.login.LoginRequest
import com.dev.groomi.auth.repository.login.LoginResult
import com.dev.groomi.auth.login.test_utils.LoginActions
import com.dev.groomi.auth.login.test_utils.LoginTestSetup
import com.dev.groomi.auth.login.test_utils.createLoginTestSetup
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.verify

class LoginRepositoryTest {
    private lateinit var loginSetup: LoginTestSetup
    @Before
    fun givenLoginRepository() {
        loginSetup = createLoginTestSetup()
    }
    @Test
    fun successfulLoginSavesToken(): Unit = runTest {
        LoginActions.givenSuccessfulLogin(loginSetup.api)
        val whenOurResult = loginSetup.repository.login(
            "jimmie@example.com",
            "Password123!"
        )
        Assert.assertTrue(whenOurResult is LoginResult.Success)
        verify(loginSetup.tokenManager)
            .saveToken("fake-jwt-token")
        verify(loginSetup.api)
            .login(
                LoginRequest(
                    "jimmie@example.com",
                    "Password123!"
                )
            )
    }
    @Test
    fun invalidCredentialsLoginReturnsError(): Unit = runTest {
        LoginActions.givenInvalidCredentials(loginSetup.api)
        val whenOurResult = loginSetup.repository.login(
            "incorrectEmail@example.com",
            "WrongPassword123!"
        )
        Assert.assertTrue(whenOurResult is LoginResult.Failure)
    }
    @Test
    fun serverErrorReturnsFailure(): Unit = runTest {
        LoginActions.givenServerError(loginSetup.api)
        val whenOurResult = loginSetup.repository.login(
            "jimmie@example.com",
            "Password123!"
        )
        Assert.assertTrue(whenOurResult is LoginResult.Failure)
    }
}