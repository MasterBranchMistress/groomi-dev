package com.dev.groomi.shared.ui.components.buttons

import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun GroomiTextButton(buttonText: String, temporaryText: String = "", onClick: () -> Unit){
    TextButton(
        onClick = onClick
    ) {
        Text(buttonText)
    }
}