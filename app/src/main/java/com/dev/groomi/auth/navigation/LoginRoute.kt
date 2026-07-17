package com.dev.groomi.auth.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.LoginScreen
import com.dev.groomi.auth.viewmodel.LoginViewModel
import com.dev.groomi.shared.navigation.Screen
import kotlinx.coroutines.launch


@Composable
fun LoginRoute(
    navController: NavController
) {
    val viewModel: LoginViewModel = hiltViewModel()
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
                        message = error
                    )
                }
            })
        },
        onRegisterClick = {
            navController.navigate(Screen.Register.route)
        }
    )
}