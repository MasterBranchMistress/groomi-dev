package com.dev.groomi.auth.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.LoginScreen
import com.dev.groomi.auth.viewmodel.AuthenticationViewModel
import com.dev.groomi.shared.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun LoginRoute(
    navController: NavController
) {
    val viewModel: AuthenticationViewModel = viewModel()
    val authenticationUiState by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    LoginScreen(
        uiState =  authenticationUiState,
        onEmailChange =  viewModel::onEmailChange,
        onPasswordChange =  viewModel::onPasswordChange,
        snackbarHostState =  snackbarHostState,
        onLoginClick = {
            viewModel.onLoginClick(onSuccess = {navController.navigate(Screen.Dashboard.route)}, onFailure = { error ->
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = error.message
                    )
                }
            })
        },
        onRegisterClick = {
            navController.navigate(Screen.Register.route)
        }
    )
}