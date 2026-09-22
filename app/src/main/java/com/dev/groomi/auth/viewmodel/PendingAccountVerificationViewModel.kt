package com.dev.groomi.auth.viewmodel

import androidx.lifecycle.ViewModel
import com.dev.groomi.auth.repository.account_verification.PendingAccountVerificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class AccountVerificationUiState(
    val isLoading: Boolean = false,
)

@HiltViewModel
class PendingAccountVerificationViewModel @Inject constructor(
    private val repository: PendingAccountVerificationRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AccountVerificationUiState())
    val uiState: StateFlow<AccountVerificationUiState> = _uiState.asStateFlow()

    private fun setLoadingState(isLoading: Boolean) {
        _uiState.update {
            it.copy(isLoading = isLoading)
        }
    }
}