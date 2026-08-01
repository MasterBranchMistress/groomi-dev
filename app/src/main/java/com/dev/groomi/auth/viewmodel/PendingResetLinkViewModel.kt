package com.dev.groomi.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.groomi.auth.repository.pending_reset_link.PendingResetLinkRepositoryInterface
import com.dev.groomi.auth.repository.pending_reset_link.ResendResetLinkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PendingResetLinkUIState(
    val isLoading: Boolean =  false
)

@HiltViewModel
class PendingResetLinkViewModel @Inject constructor(private val repository: PendingResetLinkRepositoryInterface): ViewModel(){
    private val _uiState = MutableStateFlow(PendingResetLinkUIState())
    val uiState: StateFlow<PendingResetLinkUIState> = _uiState.asStateFlow()
    private var email: String = ""

    fun initialize(email: String) {
        this.email = email
    }
    fun onResendLinkClick(
        onSuccess: () -> Unit,
        onFailure:() -> Unit
    ) {
        viewModelScope.launch {
            setLoadingState(true)
            val pendingResetLinkResult =  repository.resendResetLink(email)
            setLoadingState(false)
            when(pendingResetLinkResult){
                is ResendResetLinkResult.Success -> onSuccess()
                is ResendResetLinkResult.Failure -> onFailure()
            }
        }
    }
    private fun setLoadingState(isLoading: Boolean){
        _uiState.update {
            it.copy(isLoading=isLoading)
        }
    }
}
