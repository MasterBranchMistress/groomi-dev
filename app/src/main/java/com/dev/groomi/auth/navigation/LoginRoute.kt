package com.dev.groomi.auth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.LoginScreen
import com.dev.groomi.shared.navigation.Screen

@Composable
fun LoginRoute(
    navController: NavController
) {
    LoginScreen(
        onRegisterClick = {
            navController.navigate(Screen.Register.route)
        }
    )
}