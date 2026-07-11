package com.dev.groomi.auth.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.dev.groomi.shared.ui.components.auth.AuthFooter
import com.dev.groomi.shared.ui.components.buttons.GroomiButton
import com.dev.groomi.shared.ui.components.buttons.GroomiTextButton
import com.dev.groomi.shared.ui.components.inputs.text.GroomiTextField
import com.dev.groomi.shared.ui.components.logos.GroomiLogoMain
import com.dev.groomi.shared.ui.layouts.GroomiScreen

@Composable
fun LoginScreen(onRegisterClick: () -> Unit) {
            //TODO("Replace with ViewModel")
            var email by rememberSaveable() { mutableStateOf("") }
            var password by rememberSaveable() { mutableStateOf("") }
            GroomiScreen {
                GroomiLogoMain()
                GroomiTextField(value = email, onValueChange = {email =  it}, label = "Email" )
                GroomiTextField(value=password, onValueChange = {password =  it}, visualTransformation = PasswordVisualTransformation(), label ="Password")
                GroomiButton(onClick = {/* TODO: Authenticate from ViewModel */}, text = "Login")
                GroomiTextButton(buttonText = "Forgot Password?", temporaryText = "Forgot Password coming soon!", onClick = {println(message = "Forgot Password Clicked.")} )
                AuthFooter(prompt = "Don't have an Account?", actionText = "Sign Up", onClick = onRegisterClick)
            }
        }