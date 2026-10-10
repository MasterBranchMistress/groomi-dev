package com.dev.groomi.dashboard.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.groomi.dashboard.viewmodel.DashboardUiState
import com.dev.groomi.shared.ui.components.headers.DashboardHeader
import com.dev.groomi.shared.ui.layouts.GroomiScreen
import com.dev.groomi.shared.ui.layouts.GroomiScreenAuthenticated
import com.dev.groomi.ui.theme.FontSize.Heading
import com.dev.groomi.ui.theme.FontSize.Subtitle
import com.dev.groomi.ui.theme.FontSize.Title

@Composable
fun DashboardScreen(uiState: DashboardUiState){
    GroomiScreenAuthenticated() {
        Text(text = "Welcome back, ${uiState.firstName}! 👋", fontSize = Title, textAlign = TextAlign.Left
        )
        Text(text = "Today's Breakdown..", fontSize = Subtitle, textAlign = TextAlign.Left, color = Color.Gray
        )
        DashboardCarouselHero()
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen(uiState = DashboardUiState(firstName = "Test"))
}