package com.dev.groomi.auth.navigation.auth

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.RegisterSuccessScreen
import com.dev.groomi.auth.ui.SuccessfulAccountVerificationScreen
import com.dev.groomi.shared.navigation.Screen

@Composable
fun SuccessfulAccountVerificationRoute(navController: NavController){
    val snackbarHostState = remember { SnackbarHostState() }
    SuccessfulAccountVerificationScreen(snackbarHostState, onLoginClick = {navController.navigate(Screen.Login.route)})
}

