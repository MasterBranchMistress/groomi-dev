package com.dev.groomi.auth.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.ForgotPasswordScreen
import com.dev.groomi.auth.viewmodel.ForgotPasswordViewModel
import com.dev.groomi.shared.navigation.Screen

@Composable
fun ForgotPasswordRoute(
    navController: NavController
){
    val viewModel: ForgotPasswordViewModel = hiltViewModel()
    val forgotPasswordUIState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    ForgotPasswordScreen(
        uiState = forgotPasswordUIState,
        onEmailChange = viewModel::onEmailChange,
        snackbarHostState = snackbarHostState,
        onLoginClick = {navController.navigate(Screen.Login.route)},
        onSendCodeClick = {viewModel.onSendCodeClick({navController.currentBackStackEntry
            ?.savedStateHandle
            ?.set("email", viewModel::onEmailChange)
            navController.navigate(Screen.PendingResetLink.route)}, onFailure = {navController.navigate(Screen.PendingResetLink.route)})}
    )
}