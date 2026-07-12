package com.dev.groomi.auth.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.groomi.auth.viewmodel.RegisterUiState
import com.dev.groomi.shared.ui.components.auth.AuthFooter
import com.dev.groomi.shared.ui.components.buttons.GroomiButton
import com.dev.groomi.shared.ui.components.inputs.text.GroomiTextField
import com.dev.groomi.shared.ui.components.logos.GroomiLogoMain
import com.dev.groomi.shared.ui.components.logos.GroomiLogoSecondary
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
    uiState: RegisterUiState
){
    GroomiScreen() {
        GroomiLogoMain()
        GroomiTextField(value = uiState.firstName, onValueChange = onFirstNameChange, label = "First Name", errorMessage = uiState.firstNameError)
        GroomiTextField(value = uiState.lastName, onValueChange = onLastNameChange, label = "Last Name", errorMessage = uiState.lastNameError )
        GroomiTextField(value = uiState.email, onValueChange = onEmailChange, label = "Email", errorMessage = uiState.emailError )
        GroomiTextField(value = uiState.phoneNumber, onValueChange = onPhoneNumberChange, label = "Phone", errorMessage = uiState.phoneNumberError)
        GroomiTextField(value = uiState.password, onValueChange = onPasswordChange, visualTransformation = PasswordVisualTransformation(), label = "Password", errorMessage = uiState.passwordError)
        GroomiTextField(value = uiState.confirmPassword, onValueChange = onConfirmPasswordChange, visualTransformation = PasswordVisualTransformation(), label = "Confirm Password" )
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
        onConfirmPasswordChange = {}
    )
}