package com.dev.groomi.auth.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.dev.groomi.auth.viewmodel.RegisterUiState
import com.dev.groomi.shared.ui.components.auth.AuthFooter
import com.dev.groomi.shared.ui.components.buttons.GroomiButton
import com.dev.groomi.shared.ui.components.inputs.text.GroomiTextField
import com.dev.groomi.shared.ui.components.logos.GroomiLogoMain
import com.dev.groomi.shared.ui.layouts.GroomiScreen

@Composable
fun RegisterScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    uiState: RegisterUiState,
    snackbarHostState: SnackbarHostState
){
    GroomiScreen(snackbarHostState = snackbarHostState) {
        GroomiLogoMain()
        GroomiTextField(value = uiState.firstName, onValueChange = onFirstNameChange, label = "First Name", errorMessage = uiState.firstNameError, supportingText = "Full first name.")
        GroomiTextField(value = uiState.lastName, onValueChange = onLastNameChange, label = "Last Name", errorMessage = uiState.lastNameError, supportingText = "Full last name." )
        GroomiTextField(value = uiState.email, onValueChange = onEmailChange, label = "Email", errorMessage = uiState.emailError, supportingText = "Must be a valid email address." )
        GroomiTextField(value = uiState.phoneNumber, onValueChange = onPhoneNumberChange, label = "Phone", errorMessage = uiState.phoneNumberError, supportingText = "Must be a valid phone number.")
        GroomiTextField(value = uiState.password, onValueChange = onPasswordChange, visualTransformation = PasswordVisualTransformation(), label = "Password", errorMessage = uiState.passwordError, supportingText = "Must have: 6 Characters, 1 uppercase letter, 1 special character.")
        GroomiTextField(value = uiState.confirmPassword, onValueChange = onConfirmPasswordChange, visualTransformation = PasswordVisualTransformation(), label = "Confirm Password", supportingText = "Confirm your chosen password." )
        GroomiButton(onClick=onRegisterClick, text = "Register", isLoading = uiState.isLoading)
        AuthFooter(prompt = "Already have an account?", actionText = "Sign in", onClick = onLoginClick)
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview(){
    RegisterScreen(
        uiState = RegisterUiState(),
        onLoginClick = {},
        onRegisterClick = {},
        onFirstNameChange = {},
        onLastNameChange = {},
        onEmailChange = {},
        onPhoneNumberChange = {},
        onPasswordChange = {},
        snackbarHostState = SnackbarHostState(),
        onConfirmPasswordChange = {}
    )
}