package com.dev.groomi.shared.ui.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dev.groomi.ui.theme.Amethyst
import com.dev.groomi.ui.theme.Dimensions
import com.dev.groomi.ui.theme.FontSize
import com.dev.groomi.ui.theme.RoyalOrchid

@Composable
fun GroomiButton(onClick: () -> Unit, text: String, isLoading: Boolean, modifier: Modifier = Modifier){
    Button(
        onClick = onClick,
        enabled = !isLoading,
        shape = RoundedCornerShape(Dimensions.ButtonCornerRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = RoyalOrchid,
        ),
        modifier = Modifier
            .height(Dimensions.ButtonHeight)
            .fillMaxWidth()

    ) {
        if(isLoading) CircularProgressIndicator(color = RoyalOrchid, trackColor = Amethyst, modifier = Modifier.size(
            Dimensions.ButtonLoadingSpinnerSize)) else Text(text = text, fontSize = FontSize.BodyLarge)
    }
}