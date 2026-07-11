package com.dev.groomi.shared.ui.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dev.groomi.ui.theme.Dimensions
import com.dev.groomi.ui.theme.FontSize

@Composable
fun GroomiButton(onClick: () -> Unit, text: String){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(Dimensions.ButtonCornerRadius),
        modifier = Modifier
            .height(Dimensions.ButtonHeight)
            .fillMaxWidth()

    ) {
        Text(text = text, fontSize = FontSize.BodyLarge)
    }
}