package com.dev.groomi.shared.ui.components.feedback

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dev.groomi.ui.theme.Dimensions
import com.dev.groomi.ui.theme.Error
import com.dev.groomi.ui.theme.RoyalOrchid

@Composable
fun GroomiSnackbarHost(
    hostState: SnackbarHostState?,
    modifier: Modifier = Modifier
) {
    if (hostState != null) {
        SnackbarHost(
            hostState = hostState,
            modifier = modifier
        ) { snackbarData ->
            Snackbar(
                snackbarData = snackbarData,
                containerColor = Error,
                contentColor = Color.White,
                shape = RoundedCornerShape(Dimensions.ButtonCornerRadius)
            )
        }
    }
}