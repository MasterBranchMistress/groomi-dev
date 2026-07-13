package com.dev.groomi.dashboard.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.dev.groomi.shared.ui.components.logos.GroomiLogoMain
import com.dev.groomi.shared.ui.components.logos.GroomiLogoSecondary
import com.dev.groomi.shared.ui.layouts.GroomiScreen

@Composable
fun DashboardScreen(){
    GroomiScreen {
        GroomiLogoSecondary()
        Text("Welcome Back! \uD83D\uDC4B")
    }
}