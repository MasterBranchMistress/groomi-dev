package com.dev.groomi.auth.login

import com.dev.groomi.auth.login.test_utils.LoginActions
import com.dev.groomi.auth.login.test_utils.LoginTestSetup
import com.dev.groomi.auth.login.test_utils.createLoginTestSetup
import com.dev.groomi.auth.repository.login.LoginResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {
   private lateinit var loginSetup: LoginTestSetup

    @Before
    fun givenLoginRepository() {
        loginSetup = createLoginTestSetup()
    }

    @Test
    fun initialStateIsEmpty() {
        val viewModel = loginSetup.viewModel
        val state = viewModel.uiState.value
        assertEquals("", state.email)
        assertEquals("", state.password)
        assertFalse(state.isLoading)
        assertNull(state.emailError)
        assertNull(state.passwordError)
    }
    @Test
    fun `onEmailChange updates email`() {
        loginSetup.viewModel.onEmailChange("jim@test.com")
        assertEquals("jim@test.com", loginSetup.viewModel.uiState.value.email)
    }
    @Test
    fun `onPasswordChange updates password`() {
        loginSetup.viewModel.onPasswordChange("test_password")
        assertEquals("test_password", loginSetup.viewModel.uiState.value.password)
    }
    @Test
    fun `invalid email returns ui error`(){
        loginSetup.viewModel.onEmailChange("")
        loginSetup.viewModel.onPasswordChange("test_password")
        loginSetup.viewModel.onLoginClick({},{})
        assertEquals("Email is required.",loginSetup.viewModel.uiState.value.emailError)
    }
    @Test
    fun `invalid password returns ui error`(){
        loginSetup.viewModel.onEmailChange("jim@test.com")
        loginSetup.viewModel.onPasswordChange("")
        loginSetup.viewModel.onLoginClick({},{})
        assertEquals("Password is required",loginSetup.viewModel.uiState.value.passwordError)
    }
}