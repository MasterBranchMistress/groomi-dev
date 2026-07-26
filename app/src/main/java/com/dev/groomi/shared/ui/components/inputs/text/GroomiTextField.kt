package com.dev.groomi.shared.ui.components.inputs.text

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.dev.groomi.ui.theme.Amethyst
import com.dev.groomi.ui.theme.CarbonBlack
import com.dev.groomi.ui.theme.Dimensions
import com.dev.groomi.ui.theme.Error
import com.dev.groomi.ui.theme.RoyalOrchid
import com.dev.groomi.ui.theme.Spacing

@Composable
fun GroomiTextField(value: String,
                    onValueChange: (String) -> Unit,
                    label: String,
                    modifier: Modifier = Modifier,
                    type: GroomiInputFieldType = GroomiInputFieldType.DEFAULT,
                    errorMessage: String?=null){
    var passwordVisible by remember {
        mutableStateOf(false)
    }
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
        visualTransformation =
            if (type == GroomiInputFieldType.PASSWORD && !passwordVisible)
                PasswordVisualTransformation()
            else
                VisualTransformation.None,
        trailingIcon =
            if (type == GroomiInputFieldType.PASSWORD) {
                {
                    IconButton(
                        onClick = {
                            passwordVisible = !passwordVisible
                        }
                    ) {
                        Icon(
                            imageVector =
                                if (passwordVisible)
                                    Icons.Default.Visibility
                                else
                                    Icons.Default.VisibilityOff,
                            contentDescription =
                                if (passwordVisible)
                                    "Hide password"
                                else
                                    "Show password"
                        )
                    }
                }
            } else {
                null
            },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedLabelColor = CarbonBlack,
            focusedLabelColor = RoyalOrchid,
            unfocusedBorderColor = CarbonBlack,
            focusedBorderColor = RoyalOrchid,
            cursorColor = CarbonBlack,
            unfocusedSupportingTextColor = CarbonBlack,
            focusedSupportingTextColor = Amethyst
        ),
        
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Spacing.sm)
            .height(Dimensions.TextFieldHeight),
        isError = errorMessage != null,
        singleLine = true
    )
}