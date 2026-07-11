package com.dev.groomi.shared.ui.components.buttons

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun GroomiTextButton(buttonText: String, temporaryText: String = "", onClick: () -> Unit){
    TextButton(
        onClick = onClick
    ) {
        Text(buttonText)
    }
}