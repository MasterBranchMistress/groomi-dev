package com.dev.groomi.auth.navigation.auth

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.PasswordResetScreen
import com.dev.groomi.auth.viewmodel.ResetPasswordViewModel
import com.dev.groomi.shared.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun ResetPasswordRoute(
    navController: NavController,
    token: String?
){
    val viewModel: ResetPasswordViewModel = hiltViewModel()
    val resetPasswordUiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    PasswordResetScreen(
        uiState = resetPasswordUiState,
        onPasswordChange = viewModel::onPasswordChange,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
        snackbarHostState = snackbarHostState,
        onLoginClick = {navController.navigate(Screen.Login.route)},
        onResetPasswordClick = {
            viewModel.onResetPasswordClick(
                onSuccess = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Password reset clicked.")
                    }
                },
                onFailure = { message ->
                    scope.launch {
                        snackbarHostState.showSnackbar(message)
                    }
                }
            )
        })
}