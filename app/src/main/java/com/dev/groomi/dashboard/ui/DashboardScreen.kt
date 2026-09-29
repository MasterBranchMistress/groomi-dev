package com.dev.groomi.dashboard.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dev.groomi.shared.ui.components.headers.DashboardHeader
import com.dev.groomi.shared.ui.layouts.GroomiScreen
import com.dev.groomi.shared.ui.layouts.GroomiScreenAuthenticated

@Composable
fun DashboardScreen(){
    GroomiScreenAuthenticated() {
        Text("Welcome Back! \uD83D\uDC4B")
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen()
}