package com.dev.groomi.dashboard.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dev.groomi.dashboard.viewmodel.DashboardUiState
import com.dev.groomi.shared.ui.components.headers.DashboardHeader
import com.dev.groomi.shared.ui.layouts.GroomiScreen
import com.dev.groomi.shared.ui.layouts.GroomiScreenAuthenticated

@Composable
fun DashboardScreen(uiState: DashboardUiState){
    GroomiScreenAuthenticated() {
        Text("Welcome back, ${uiState.firstName}! 👋")
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen(uiState = DashboardUiState())
}