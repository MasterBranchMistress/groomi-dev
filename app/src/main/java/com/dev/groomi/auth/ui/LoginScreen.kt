package com.dev.groomi.auth.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.dev.groomi.auth.viewmodel.AuthenticationUiState
import com.dev.groomi.shared.ui.components.auth.AuthFooter
import com.dev.groomi.shared.ui.components.buttons.GroomiButton
import com.dev.groomi.shared.ui.components.buttons.GroomiTextButton
import com.dev.groomi.shared.ui.components.inputs.text.GroomiTextField
import com.dev.groomi.shared.ui.components.logos.GroomiLogoMain
import com.dev.groomi.shared.ui.layouts.GroomiScreen

@Composable
fun LoginScreen(
    onRegisterClick: () -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    uiState: AuthenticationUiState,
) {
            GroomiScreen{
                GroomiLogoMain()
                GroomiTextField(value = uiState.email, onValueChange = onEmailChange, label = "Email" )
                GroomiTextField(value=uiState.password, onValueChange = onPasswordChange, visualTransformation = PasswordVisualTransformation(), label ="Password")
                GroomiButton(onClick = onLoginClick, text = "Login")
                GroomiTextButton(buttonText = "Forgot Password?", temporaryText = "Forgot Password coming soon!", onClick = {println(message = "Forgot Password Clicked.")} )
                AuthFooter(prompt = "Don't have an Account?", actionText = "Sign Up", onClick = onRegisterClick)
            }
        }
@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {

    LoginScreen(
        onRegisterClick = {},
        onEmailChange = {},
        onPasswordChange = {},
        onLoginClick = {},
        uiState = AuthenticationUiState(),
    )

}