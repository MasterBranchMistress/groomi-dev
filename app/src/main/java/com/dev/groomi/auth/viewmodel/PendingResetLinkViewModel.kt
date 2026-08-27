package com.dev.groomi.auth.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class PendingResetLinkUIState(
    val isLoading: Boolean =  false
)

@HiltViewModel
class PendingResetLinkViewModel @Inject constructor(): ViewModel(){
    private val _uiState = MutableStateFlow(PendingResetLinkUIState())
    val uiState: StateFlow<PendingResetLinkUIState> = _uiState.asStateFlow()
}
