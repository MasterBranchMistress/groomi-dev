package com.dev.groomi.auth.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.LoginScreen
import com.dev.groomi.auth.viewmodel.AuthenticationViewModel
import com.dev.groomi.shared.navigation.Screen

@Composable
fun LoginRoute(
    navController: NavController
) {
    val viewModel: AuthenticationViewModel = viewModel()
    val authenticationUiState by viewModel.uiState.collectAsState()
    LoginScreen(
        uiState =  authenticationUiState,
        onEmailChange =  viewModel::onEmailChange,
        onPasswordChange =  viewModel::onPasswordChange,
        onLoginClick =  viewModel::onLoginClick,
        onRegisterClick = {
            navController.navigate(Screen.Register.route)
        }
    )
}