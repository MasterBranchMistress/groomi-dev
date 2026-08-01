package com.dev.groomi.auth.navigation.auth

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.groomi.auth.ui.PendingResetLinkScreen
import com.dev.groomi.auth.viewmodel.PendingResetLinkViewModel
import com.dev.groomi.shared.navigation.Screen

@Composable
fun PendingResetLinkRoute(
    navController: NavController
){
    val viewModel: PendingResetLinkViewModel = hiltViewModel()
    val pendingResetLinkUIState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    PendingResetLinkScreen(
        uiState = pendingResetLinkUIState,
        snackbarHostState = snackbarHostState,
        onLoginClick = { navController.navigate(Screen.Login.route) },
        onResendLink = {viewModel.onResendLinkClick(onSuccess = {}, onFailure = {})}
    )
}