package com.dev.groomi.shared.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){
    val navController =  rememberNavController()
    NavHost(navController =  navController, startDestination = Screen.Login){
        composable(Screen.Login.route){
            LoginScreen()
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
fun LoginScreen() {
    Text("Login here.")
}