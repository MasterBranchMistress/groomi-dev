package com.dev.groomi.dashboard.repository

interface DashboardRepositoryInterface {

    suspend fun loadUserDashboard(
    ): LoadUserDashboardResult
}

