package com.dev.groomi.auth.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.dev.groomi.R
import com.dev.groomi.ui.theme.Dimensions
import com.dev.groomi.ui.theme.FontSize
import com.dev.groomi.ui.theme.Spacing

@Composable
fun LoginScreen(onRegisterClick: () -> Unit) {
    var email by rememberSaveable() { mutableStateOf("") }
    var password by rememberSaveable() { mutableStateOf("") }
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize().background(Color.White)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Spacing.lg),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.padding(bottom = Spacing.lg),
                painter = painterResource(id = R.drawable.groomi_main_logo),
                contentDescription = stringResource(id = R.string.app_name)
            )
            OutlinedTextField(
                value = email,
                modifier = Modifier.fillMaxWidth().padding(bottom = Spacing.md).height(Dimensions.TextFieldHeight),
                onValueChange = { email = it },
                label = { Text("Email") }
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = Spacing.lg)
                    .height(Dimensions.TextFieldHeight),
                singleLine = true
            )
            Button(
                onClick = {
                    // Handle login logic here
                    println("Email: $email")
                    println("Password: $password")
                },  shape = RoundedCornerShape(Dimensions.ButtonCornerRadius),
                modifier = Modifier
                    .height(Dimensions.ButtonHeight)
                    .fillMaxWidth()

            ) {
                Text(text = "Login", fontSize = FontSize.Body)
            }
            TextButton(
                onClick = {
                    Toast.makeText(
                        context,
                        "Forgot Password coming soon!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ) {
                Text("Forgot Password?")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {

                Text("Don't have an account?")
                TextButton(
                    onClick = onRegisterClick
                ) {
                    Text("Sign Up")
                }
            }

        }
    }
}