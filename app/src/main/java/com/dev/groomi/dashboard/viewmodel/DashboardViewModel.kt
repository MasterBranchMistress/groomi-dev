package com.dev.groomi.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.groomi.dashboard.repository.DashboardRepositoryInterface
import com.dev.groomi.dashboard.repository.LoadUserDashboardResult
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.log

data class DashboardUiState(
    val isLoading: Boolean = false,
    val userIsAuthenticated: Boolean = false,
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val error: String? = null
)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: DashboardRepositoryInterface
) : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    fun loadUserDashboard() {
        viewModelScope.launch {
            setLoadingState(true)
            when (val result = repository.loadUserDashboard()) {
                is LoadUserDashboardResult.Success -> {
                    val user = result.data.data
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            userIsAuthenticated = true,
                            firstName = user.firstName,
                            lastName = user.lastName,
                            email = user.email,
                            error = null
                        )
                    }
                }

                is LoadUserDashboardResult.Failure -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            userIsAuthenticated = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }

    private fun setLoadingState(isLoading: Boolean) {
        _uiState.update {
            it.copy(isLoading = isLoading)
        }
    }
}

