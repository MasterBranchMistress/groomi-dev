package com.dev.groomi.auth.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dev.groomi.shared.ui.components.buttons.GroomiTextButton
import com.dev.groomi.shared.ui.components.logos.GroomiLogoMain
import com.dev.groomi.shared.ui.layouts.GroomiScreen

@Composable
fun RegisterSuccessScreen(snackbarHostState: SnackbarHostState, onLoginClick: () -> Unit){
    GroomiScreen(
    snackbarHostState = snackbarHostState
    ){
        GroomiLogoMain()
        Text(
            text = "Hi  \uD83D\uDC4B",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Please check your email.",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "You will need to verify your account before logging in. Don't forget to check your spam folders as well. Thank you!",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        )
        GroomiTextButton(
            buttonText = "Back to Login",
            onClick = onLoginClick
        )
    }
}