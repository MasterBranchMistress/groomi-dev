package com.dev.groomi.shared.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.groomi.auth.navigation.LoginRoute
import com.dev.groomi.auth.navigation.RegisterRoute


@Composable
fun AppNavigation(){
    val navController =  rememberNavController()
    NavHost(navController =  navController, startDestination = Screen.Login.route){
        composable(Screen.Login.route){
            LoginRoute(navController)
        }
        composable(Screen.Register.route) {
            RegisterRoute(navController)
        }
    }
}

