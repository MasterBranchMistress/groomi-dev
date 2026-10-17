package com.dev.groomi.dashboard.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.dev.groomi.dashboard.dto.job_summary.fake_data.fakeUpcomingJobs
import com.dev.groomi.dashboard.viewmodel.DashboardUiState
import com.dev.groomi.shared.ui.layouts.GroomiScreenAuthenticated
import com.dev.groomi.ui.theme.FontSize.Subtitle
import com.dev.groomi.ui.theme.FontSize.Title

@Composable
fun DashboardScreen(
    uiState: DashboardUiState,
    onSearchQueryChanged: (String) -> Unit,
    onSearchSubmitted: (String) -> Unit,
    onSearchExpandedChange: (Boolean) -> Unit
) {
    GroomiScreenAuthenticated(
        searchResults = uiState.searchResults,
        searchQuery = uiState.searchQuery,
        onSearchQueryChanged = onSearchQueryChanged,
        onSearchSubmitted = onSearchSubmitted,
        onSearchExpandedChange = onSearchExpandedChange,
        snackbarHostState = null,
        content = {
            Text(
                text = "Welcome back, ${uiState.firstName}! 👋",
                fontSize = Title,
                textAlign = TextAlign.Left
            )

            Text(
                text = "Today's Breakdown",
                fontSize = Subtitle,
                textAlign = TextAlign.Left,
                color = Color.Gray
            )

            DashboardCarouselHero()
            DashboardJobSummary(jobs = fakeUpcomingJobs)
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen(
        uiState = DashboardUiState(firstName = "Test"),
        onSearchQueryChanged = {},
        onSearchSubmitted = {},
        onSearchExpandedChange = {}
    )
}