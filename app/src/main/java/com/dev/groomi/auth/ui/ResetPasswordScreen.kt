package com.dev.groomi.auth.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dev.groomi.auth.viewmodel.ResetPasswordUiState
import com.dev.groomi.shared.ui.components.buttons.GroomiButton
import com.dev.groomi.shared.ui.components.buttons.GroomiTextButton
import com.dev.groomi.shared.ui.components.inputs.text.GroomiInputFieldType
import com.dev.groomi.shared.ui.components.inputs.text.GroomiTextField
import com.dev.groomi.shared.ui.components.logos.GroomiLogoMain
import com.dev.groomi.shared.ui.layouts.GroomiScreen

@Composable
fun PasswordResetScreen(
    onResetPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    uiState: ResetPasswordUiState,
    snackbarHostState: SnackbarHostState
){
    GroomiScreen(snackbarHostState = snackbarHostState){
        GroomiLogoMain()
        GroomiTextField(value = uiState.password, onValueChange = onPasswordChange, label = "New Password", errorMessage = uiState.passwordError, type = GroomiInputFieldType.PASSWORD)
        GroomiTextField(value=uiState.confirmPassword, onValueChange = onConfirmPasswordChange, label ="Confirm New Password", errorMessage = uiState.confirmPasswordError, type = GroomiInputFieldType.PASSWORD)
        GroomiButton(onClick = onResetPasswordClick, text = "Reset Password", isLoading = uiState.isLoading)
        GroomiTextButton(buttonText = "Back to Login", temporaryText = "Forgot Password coming soon!", onClick = onLoginClick)
    }
}

@Preview(showBackground = true)
@Composable
private fun ResetPasswordScreenPreview() {

    PasswordResetScreen(
        onLoginClick = {},
        onPasswordChange = {},
        onConfirmPasswordChange = {},
        snackbarHostState = SnackbarHostState(),
        onResetPasswordClick = {},
        uiState = ResetPasswordUiState(),
    )

}