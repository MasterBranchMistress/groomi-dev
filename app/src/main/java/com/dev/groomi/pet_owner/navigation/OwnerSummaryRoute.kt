package com.dev.groomi.pet_owner.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.groomi.dashboard.viewmodel.DashboardViewModel
import com.dev.groomi.pet_owner.ui.OwnerSummaryScreen
import com.dev.groomi.pet_owner.viewmodel.OwnerSummaryViewModel

@Composable
fun OwnerSummaryRoute(
    navController: NavController
) {
    val viewModel: OwnerSummaryViewModel = hiltViewModel()
    val dashViewModel: DashboardViewModel =  hiltViewModel()
    val ownerSummaryUiState by viewModel.uiState.collectAsState()
    val dashboardUiState by dashViewModel.uiState.collectAsState()

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.loadPetOwnerInformation()
    }



    OwnerSummaryScreen(
        dashboardUiState = dashboardUiState,
        ownerSummaryUiState = ownerSummaryUiState,
        snackbarHostState = snackbarHostState,
        onSearchQueryChanged = dashViewModel::onSearchQueryChanged,
        onSearchSubmitted = dashViewModel::onSearchSubmitted,
        onSearchExpandedChange = dashViewModel::onSearchExpandedChange
    )
}

