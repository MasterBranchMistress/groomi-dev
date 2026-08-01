package com.dev.groomi.shared.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.groomi.auth.navigation.auth.ForgotPasswordRoute
import com.dev.groomi.auth.navigation.auth.LoginRoute
import com.dev.groomi.auth.navigation.auth.PendingResetLinkRoute
import com.dev.groomi.auth.navigation.auth.RegisterRoute
import com.dev.groomi.dashboard.navigation.DashboardRoute


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
        composable(Screen.ForgotPassword.route) {
            ForgotPasswordRoute(navController)
        }
        composable(Screen.PendingResetLink.route) {
            PendingResetLinkRoute(navController)
        }
        composable(Screen.Dashboard.route) {
            DashboardRoute(navController)
        }
    }
}

