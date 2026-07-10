package com.dev.groomi.shared.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.groomi.auth.ui.LoginScreen

@Preview
@Composable
fun AppNavigation(){
    val navController =  rememberNavController()
    NavHost(navController =  navController, startDestination = Screen.Login.route){
        composable(Screen.Login.route){
            Login(onRegisterClick = {
                navController.navigate(Screen.Register.route)
            })
        }
        composable(Screen.Register.route) {
            RegisterScreen()
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }
    }
}

@Composable
fun DashboardScreen() {
    Text("Welcome back!")
}

@Composable
fun RegisterScreen() {
    Text("Register here.")
}

@Composable
fun Login(onRegisterClick: () -> Unit) {
    LoginScreen(onRegisterClick = onRegisterClick)
}