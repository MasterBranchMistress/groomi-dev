package com.dev.groomi.auth.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.RegisterScreen
import com.dev.groomi.auth.viewmodel.RegisterViewModel
import com.dev.groomi.shared.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun RegisterRoute(navController: NavController) {
    val viewModel: RegisterViewModel = viewModel()
    val registerUiState by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    RegisterScreen(
        uiState = registerUiState,
        onFirstNameChange = viewModel::onFirstNameChange,
        onLastNameChange = viewModel::onLastNameChange,
        onEmailChange = viewModel::onEmailChange,
        onPhoneNumberChange = viewModel::onPhoneNumberChange,
        onPasswordChange = viewModel::onPasswordChange,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
        onRegisterClick = {
            viewModel.onRegisterClick(
                onSuccess = { navController.navigate(Screen.Login.route) },
                onFailure = { error ->
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = error.message
                        )
                    }
                }
            )
        },
        onLoginClick = { navController.navigate(Screen.Login.route) },
        snackbarHostState = snackbarHostState
    )
}