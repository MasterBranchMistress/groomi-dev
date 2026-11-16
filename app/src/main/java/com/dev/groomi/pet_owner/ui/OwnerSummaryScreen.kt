package com.dev.groomi.pet_owner.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dev.groomi.dashboard.viewmodel.DashboardUiState
import com.dev.groomi.pet_owner.ui.components.OwnerSummaryCard
import com.dev.groomi.pet_owner.viewmodel.OwnerSummaryUiState
import com.dev.groomi.shared.ui.components.cards.SummaryCard
import com.dev.groomi.shared.ui.components.cards.SummaryDetail
import com.dev.groomi.shared.ui.layouts.GroomiScreenAuthenticated

@Composable
fun OwnerSummaryScreen(
    dashboardUiState: DashboardUiState,
    ownerSummaryUiState: OwnerSummaryUiState,
    snackbarHostState: SnackbarHostState,
    onSearchQueryChanged: (String) -> Unit,
    onSearchSubmitted: (String) -> Unit,
    onSearchExpandedChange: (Boolean) -> Unit


) {
    GroomiScreenAuthenticated(
        searchResults = dashboardUiState.searchResults,
        searchQuery = dashboardUiState.searchQuery,
        onSearchQueryChanged = onSearchQueryChanged,
        onSearchSubmitted = onSearchSubmitted,
        onSearchExpandedChange = onSearchExpandedChange,
        snackbarHostState = snackbarHostState,
        content = {
            OwnerSummaryCard(ownerSummaryUiState = ownerSummaryUiState,
                onEditClick = {},
                onDeleteClick = {},
                onMessageClick = {})
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun OwnerSummaryScreenPreview() {
    OwnerSummaryScreen(
        dashboardUiState = DashboardUiState(),
        ownerSummaryUiState = OwnerSummaryUiState(ownerFirstName = "Jimmie", ownerLastName = "Smith", ownerEmail = "j.smith@customer.com", ownerPhoneNumber = "777-777-7777", ownerPhotoUrl = "https://images.unsplash.com/photo-1594283255808-ee728c775ba6?q=80&w=749&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=NHwxMjA3fDA%3D"),
        snackbarHostState = SnackbarHostState(),
        onSearchQueryChanged = {},
        onSearchSubmitted = {},
        onSearchExpandedChange = {},
    )
}

