package com.dev.groomi.shared.ui.components.buttons

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.dev.groomi.ui.theme.Amethyst

@Composable
fun GroomiTextButton(buttonText: String, temporaryText: String = "", onClick: () -> Unit){
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(contentColor = Amethyst, containerColor = Color.Transparent)
    ) {
        Text(buttonText)
    }
}