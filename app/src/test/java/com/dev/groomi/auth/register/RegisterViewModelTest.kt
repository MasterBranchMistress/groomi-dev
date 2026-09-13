package com.dev.groomi.auth.register

import com.dev.groomi.auth.register.test_utils.RegisterTestSetup
import com.dev.groomi.auth.register.test_utils.createRegisterTestSetup
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class RegisterViewModelTest {
    private lateinit var registerTestSetup: RegisterTestSetup

    @Before
    fun givenLoginRepository() {
        registerTestSetup = createRegisterTestSetup()
    }

    @Test
    fun initialRegisterStateIsEmpty() {
        val viewModel = registerTestSetup.viewModel
        val state = viewModel.uiState.value
        assertEquals("", state.firstName)
        assertEquals("", state.lastName)
        assertEquals("", state.phoneNumber)
        assertEquals("", state.email)
        assertEquals("", state.password)
        assertEquals("", state.confirmPassword)
        assertFalse(state.isLoading)
        assertNull(state.firstNameError)
        assertNull(state.lastNameError)
        assertNull(state.phoneNumberError)
        assertNull(state.emailError)
        assertNull(state.passwordError)
    }

    @Test
    fun `onFirstNameChange updates first name`() {
        registerTestSetup.viewModel.onFirstNameChange("jimmie")
        assertEquals("jimmie", registerTestSetup.viewModel.uiState.value.firstName)
    }
    @Test
    fun `onLastNameChange updates last name`() {
        registerTestSetup.viewModel.onLastNameChange("jimmie")
        assertEquals("jimmie", registerTestSetup.viewModel.uiState.value.lastName)
    }
    @Test
    fun `onEmailChange updates email`() {
        registerTestSetup.viewModel.onEmailChange("jimmie@test.com")
        assertEquals("jimmie@test.com", registerTestSetup.viewModel.uiState.value.email)
    }
    @Test
    fun `onPhoneNumberChange updates phone number`() {
        registerTestSetup.viewModel.onPhoneNumberChange("777-777-7777")
        assertEquals("777-777-7777", registerTestSetup.viewModel.uiState.value.phoneNumber)
    }
    @Test
    fun `onPasswordChange updates password`() {
        registerTestSetup.viewModel.onPasswordChange("testpass123")
        assertEquals("testpass123", registerTestSetup.viewModel.uiState.value.password)
    }
    @Test
    fun `onConfirmPasswordChange updates confirm password`() {
        registerTestSetup.viewModel.onConfirmPasswordChange("testpass123")
        assertEquals("testpass123", registerTestSetup.viewModel.uiState.value.confirmPassword)
    }
}