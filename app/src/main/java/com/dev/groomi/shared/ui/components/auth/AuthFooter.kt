package com.dev.groomi.shared.ui.components.auth

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.dev.groomi.shared.ui.components.buttons.GroomiTextButton

@Composable
fun AuthFooter(prompt: String, actionText: String, onClick: () -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(prompt)
        GroomiTextButton(buttonText = actionText, onClick = onClick)
    }
}