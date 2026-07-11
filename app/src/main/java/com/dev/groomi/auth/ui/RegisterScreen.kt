package com.dev.groomi.auth.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.dev.groomi.shared.ui.components.auth.AuthFooter
import com.dev.groomi.shared.ui.components.buttons.GroomiButton
import com.dev.groomi.shared.ui.components.inputs.text.GroomiTextField
import com.dev.groomi.shared.ui.components.logos.GroomiLogoMain
import com.dev.groomi.shared.ui.layouts.GroomiScreen

@Composable
fun RegisterScreen(onLoginClick: () -> Unit){
    //TODO("Replace with ViewModel")
    var firstName by rememberSaveable() { mutableStateOf("") }
    var lastName by rememberSaveable() { mutableStateOf("") }
    var email by rememberSaveable() {mutableStateOf("") }
    var phoneNumber by rememberSaveable() {mutableStateOf("") }
    var password by rememberSaveable() {mutableStateOf("") }
    var confirmPassword by rememberSaveable() {mutableStateOf("") }
    GroomiScreen {
        GroomiLogoMain()
        GroomiTextField(value = firstName, onValueChange = {firstName = it}, label = "First Name" )
        GroomiTextField(value = lastName, onValueChange = {lastName = it}, label = "Last Name" )
        GroomiTextField(value = email, onValueChange = {email = it}, label = "Email" )
        GroomiTextField(value = phoneNumber, onValueChange = {phoneNumber = it}, label = "Phone" )
        GroomiTextField(value = password, onValueChange = {password = it}, visualTransformation = PasswordVisualTransformation(), label = "Password" )
        GroomiTextField(value = confirmPassword, onValueChange = {confirmPassword = it}, visualTransformation = PasswordVisualTransformation(), label = "Confirm Password" )
        GroomiButton(onClick={}, text = "Register")
        AuthFooter(prompt = "Already have an account?", actionText = "Sign in", onClick = onLoginClick)
    }
}