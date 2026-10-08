package com.dev.groomi.dashboard.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.dev.groomi.dashboard.ui.DashboardScreen
import com.dev.groomi.dashboard.viewmodel.DashboardViewModel
import com.dev.groomi.shared.ui.layouts.GroomiScreenAuthenticated

@Composable
fun DashboardRoute(
    navController: NavController,
    viewModel: DashboardViewModel = hiltViewModel()

) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }


    LaunchedEffect(Unit) {
        viewModel.loadUserDashboard()
    }
        DashboardScreen(
            uiState = uiState
        )
}