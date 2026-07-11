package com.dev.groomi.auth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.RegisterScreen
import com.dev.groomi.shared.navigation.Screen

@Composable
fun RegisterRoute(navController: NavController) {
    RegisterScreen(onLoginClick = {navController.navigate(Screen.Login.route)})
}