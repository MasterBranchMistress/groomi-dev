package com.dev.groomi.auth.navigation.auth

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.RegisterSuccessScreen
import com.dev.groomi.shared.navigation.Screen

@Composable
fun RegisterSuccessRoute(navController: NavController){
    val snackbarHostState = remember { SnackbarHostState() }
    RegisterSuccessScreen(snackbarHostState, onLoginClick = {navController.navigate(Screen.Login.route)})
}