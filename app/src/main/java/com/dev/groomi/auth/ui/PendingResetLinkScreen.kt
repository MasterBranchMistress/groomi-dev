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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.groomi.auth.viewmodel.PendingResetLinkUIState
import com.dev.groomi.shared.ui.components.buttons.GroomiButton
import com.dev.groomi.shared.ui.components.buttons.GroomiTextButton
import com.dev.groomi.shared.ui.components.logos.GroomiLogoMain
import com.dev.groomi.shared.ui.layouts.GroomiScreen


@Composable
fun PendingResetLinkScreen(
    uiState: PendingResetLinkUIState,
    snackbarHostState: SnackbarHostState,
    onResendLink: () -> Unit,
    onLoginClick: () -> Unit
) {
    GroomiScreen(snackbarHostState = snackbarHostState) {
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
            text = "If an account exists for this email, we sent a link to reset the password. Don't forget to check your spam folders as well. Thank you!",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        )
        GroomiButton(
            onClick = onResendLink,
            text = "Resend Link",
            isLoading = uiState.isLoading
        )
        GroomiTextButton(
            buttonText = "Back to Login",
            onClick = onLoginClick
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun PendingResetLinkScreenPreview() {
    PendingResetLinkScreen(snackbarHostState = SnackbarHostState(), onResendLink = {}, uiState = PendingResetLinkUIState()) { }
}