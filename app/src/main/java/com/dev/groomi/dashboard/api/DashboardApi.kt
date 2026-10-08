package com.dev.groomi.dashboard.api

import com.dev.groomi.dashboard.dto.LoadUserDashboardRequest
import com.dev.groomi.dashboard.dto.LoadUserDashboardResponse
import com.dev.groomi.shared.network.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DashboardApi {

    @POST("user/dashboard")
    suspend fun loadUserDashboard(
        @Body request: LoadUserDashboardRequest
    ): ApiResponse<LoadUserDashboardResponse>
}

