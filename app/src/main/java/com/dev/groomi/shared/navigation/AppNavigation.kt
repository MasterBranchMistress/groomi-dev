package com.dev.groomi.shared.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.dev.groomi.auth.navigation.auth.ForgotPasswordRoute
import com.dev.groomi.auth.navigation.auth.LoginRoute
import com.dev.groomi.auth.navigation.auth.PendingResetLinkRoute
import com.dev.groomi.auth.navigation.auth.RegisterRoute
import com.dev.groomi.auth.navigation.auth.ResetPasswordRoute
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
        composable(
            Screen.ResetPassword.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "groomr://reset-password?token={token}"
                }
            )
        ) { backStackEntry ->

            val token = backStackEntry.arguments?.getString("token")

            ResetPasswordRoute(
                navController = navController,
                token = token
            )
        }
    }
}

