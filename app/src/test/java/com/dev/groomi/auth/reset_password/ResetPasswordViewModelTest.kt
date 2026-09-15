package com.dev.groomi.auth.reset_password.test_utils

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ResetPasswordViewModelTest {

    private lateinit var resetPasswordTestSetup: ResetPasswordTestSetup

    @Before
    fun givenResetPasswordDependencies() {
        resetPasswordTestSetup = createResetPasswordTestSetup()
    }

    @Test
    fun initialPasswordStateIsCorrect() {
        val state = resetPasswordTestSetup.viewModel.uiState.value
        assertEquals("", state.password)
        assertEquals("", state.confirmPassword)
        assertFalse(state.isLoading)
        assertNull(state.passwordError)
    }

    @Test
    fun `onchangePassword Updates Password`() {
        resetPasswordTestSetup.viewModel.onPasswordChange("testPass123")
        assertEquals(
            "testPass123",
            resetPasswordTestSetup.viewModel.uiState.value.password
        )
    }
    @Test
    fun `onchangeConfirmPassword Updates ConfirmPassword`() {
        resetPasswordTestSetup.viewModel.onConfirmPasswordChange("testPass123")
        assertEquals(
            "testPass123",
            resetPasswordTestSetup.viewModel.uiState.value.confirmPassword
        )
    }

    @Test
    fun `ui returns error when passwords don't match`() {
        resetPasswordTestSetup.viewModel.onPasswordChange("testing")
        resetPasswordTestSetup.viewModel.onConfirmPasswordChange("testing123")

        resetPasswordTestSetup.viewModel.onChangePasswordClick({}, {})

        assertNotNull(
            "Password Error Popped Successfully",
            resetPasswordTestSetup.viewModel.uiState.value.passwordError
        )
    }

    @Test
    fun `failed reset password returns error`() = runTest {
        resetPasswordTestSetup.viewModel.onChangePasswordClick({}, {})
        advanceUntilIdle()
        assertFalse(resetPasswordTestSetup.viewModel.uiState.value.isLoading)
        assertNotNull(
            "Error popped for failed password reset",
            resetPasswordTestSetup.viewModel.uiState.value.passwordError
        )
    }
}

