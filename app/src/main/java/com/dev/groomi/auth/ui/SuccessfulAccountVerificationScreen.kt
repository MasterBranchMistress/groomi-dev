package com.dev.groomi.auth.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.groomi.shared.ui.components.buttons.GroomiTextButton
import com.dev.groomi.shared.ui.components.logos.GroomiLogoMain
import com.dev.groomi.shared.ui.layouts.GroomiScreen

@Composable
fun SuccessfulAccountVerificationScreen(
    snackbarHostState: SnackbarHostState,
    onLoginClick: () -> Unit
) {
    GroomiScreen(
        snackbarHostState = snackbarHostState
    ) {
        GroomiLogoMain()
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Hi  \uD83D\uDC4B",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "You've successfully verified your account. Happy Grooming!",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        GroomiTextButton(
            buttonText = "Back to Login",
            onClick = onLoginClick
        )


    }
}

@Preview(showBackground = true)
@Composable
private fun SuccessfulAccountVerificationScreenPreview() {
    SuccessfulAccountVerificationScreen(
        snackbarHostState = SnackbarHostState(),
        onLoginClick = {}
    )
}