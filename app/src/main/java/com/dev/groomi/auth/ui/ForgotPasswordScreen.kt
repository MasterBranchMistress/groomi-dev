package com.dev.groomi.auth.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dev.groomi.auth.viewmodel.ForgotPasswordUIState
import com.dev.groomi.shared.ui.components.buttons.GroomiButton
import com.dev.groomi.shared.ui.components.buttons.GroomiTextButton
import com.dev.groomi.shared.ui.components.inputs.text.GroomiTextField
import com.dev.groomi.shared.ui.components.logos.GroomiLogoSecondary
import com.dev.groomi.shared.ui.layouts.GroomiScreen


@Composable
fun ForgotPasswordScreen(
    onSendCodeClick:() -> Unit,
    onEmailChange: (String) -> Unit,
    uiState: ForgotPasswordUIState,
    snackbarHostState: SnackbarHostState,
    onLoginClick: () -> Unit
) {
    GroomiScreen(snackbarHostState = snackbarHostState) {
        GroomiLogoSecondary()
        GroomiTextField(value = uiState.email, onValueChange = onEmailChange, label = "Email", errorMessage = uiState.emailError)
        GroomiButton(onClick = onSendCodeClick, text = "Reset Password", isLoading = uiState.isLoading)
        GroomiTextButton(buttonText = "Back to Login", onClick = onLoginClick)
    }
}

@Preview(showBackground = true)
@Composable
private fun ForgotPasswordScreenPreview() {

    ForgotPasswordScreen(
        onSendCodeClick = {},
        onEmailChange = {},
        snackbarHostState = SnackbarHostState(),
        uiState = ForgotPasswordUIState(),
        onLoginClick = {}
    )

}