package com.dev.groomi.dashboard.repository

import com.dev.groomi.dashboard.api.DashboardApi
import com.dev.groomi.dashboard.dto.LoadUserDashboardRequest
import com.dev.groomi.dashboard.dto.LoadUserDashboardResponse
import com.dev.groomi.shared.local.auth.TokenManager
import com.dev.groomi.shared.network.ApiResponse
import com.dev.groomi.shared.utils.parseErrorMessage
import jakarta.inject.Inject
import retrofit2.HttpException
import java.io.IOException


sealed interface LoadUserDashboardResult {
    data class Success(
        val data: ApiResponse<LoadUserDashboardResponse>
    ) : LoadUserDashboardResult

    data class Failure(
        val message: String
    ) : LoadUserDashboardResult
}

class DashboardRepository @Inject constructor(
    private val api: DashboardApi,
    private val tokenManager: TokenManager
) : DashboardRepositoryInterface {

    override suspend fun loadUserDashboard(): LoadUserDashboardResult {
        val token =  tokenManager.getToken()
        assert(token != null)
        return try {
            val response = api.loadUserDashboard(LoadUserDashboardRequest(token))
            LoadUserDashboardResult.Success(
                data = response
            )
        } catch (error: HttpException) {
            val errorResponse = parseErrorMessage(error)

            LoadUserDashboardResult.Failure(
                errorResponse
            )
        } catch (_: IOException) {
            LoadUserDashboardResult.Failure(
                "Network Unavailable. Check your internet connection and try again."
            )
        }
    }
}