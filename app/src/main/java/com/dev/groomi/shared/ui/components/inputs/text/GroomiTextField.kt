package com.dev.groomi.shared.ui.components.inputs.text

import android.R.attr.text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.VisualTransformation.Companion.None
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.dev.groomi.ui.theme.Amethyst
import com.dev.groomi.ui.theme.CarbonBlack
import com.dev.groomi.ui.theme.Dimensions
import com.dev.groomi.ui.theme.Error
import com.dev.groomi.ui.theme.LavenderGrey
import com.dev.groomi.ui.theme.RoyalOrchid
import com.dev.groomi.ui.theme.Spacing

@Composable
fun GroomiTextField(value: String,
                    onValueChange: (String) -> Unit,
                    label: String,
                    modifier: Modifier = Modifier,
                    visualTransformation: VisualTransformation = None,
                    errorMessage: String?=null){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("$label*") },
        supportingText = {
            errorMessage?.let {
                Text(
                    text = it,
                    color = Error
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedLabelColor = LavenderGrey,
            focusedLabelColor = RoyalOrchid,
            unfocusedBorderColor = LavenderGrey,
            focusedBorderColor = RoyalOrchid,
            cursorColor = CarbonBlack,
            unfocusedSupportingTextColor = LavenderGrey,
            focusedSupportingTextColor = Amethyst
        ),
        visualTransformation = visualTransformation,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Spacing.sm)
            .height(Dimensions.TextFieldHeight),
        isError = errorMessage != null,
        singleLine = true
    )
}