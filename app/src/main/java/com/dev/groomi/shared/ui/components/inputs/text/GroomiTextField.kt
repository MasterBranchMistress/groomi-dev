package com.dev.groomi.shared.ui.components.inputs.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.VisualTransformation.Companion.None
import com.dev.groomi.ui.theme.Dimensions
import com.dev.groomi.ui.theme.Spacing

@Composable
fun GroomiTextField(value: String, onValueChange: (String) -> Unit, label: String, modifier: Modifier = Modifier, visualTransformation: VisualTransformation = None){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        visualTransformation = visualTransformation,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Spacing.lg)
            .height(Dimensions.TextFieldHeight),
        singleLine = true
    )

}