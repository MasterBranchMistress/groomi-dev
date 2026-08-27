package com.dev.groomi.auth.navigation.auth

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.PendingResetLinkScreen
import com.dev.groomi.shared.navigation.Screen

@Composable
fun PendingResetLinkRoute(
    navController: NavController
){
    val snackbarHostState = remember { SnackbarHostState() }
    val goBackToLoginScreen = {navController.navigate(Screen.Login.route)}

    PendingResetLinkScreen(
        snackbarHostState = snackbarHostState,
        onLoginClick = goBackToLoginScreen,
    )
}