package com.dev.groomi.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.groomi.auth.repository.forgotPassword.ForgotPasswordRepositoryInterface
import com.dev.groomi.auth.repository.forgotPassword.ForgotPasswordResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ForgotPasswordUIState(
    val email: String = "",
    val emailError: String? = null,
    val isLoading: Boolean =  false
)

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(private val repository: ForgotPasswordRepositoryInterface): ViewModel(){
    private val _uiState = MutableStateFlow(ForgotPasswordUIState())
    val uiState: StateFlow<ForgotPasswordUIState> = _uiState.asStateFlow()
    fun onEmailChange(email: String) {
        _uiState.update {
            it.copy(email = email,
                emailError = null)
        }
    }
    fun onSendCodeClick(
        onSuccess: () -> Unit,
        onFailure:() -> Unit
    ) {
        viewModelScope.launch {
            setLoadingState(true)
            val forgotPasswordResult =  repository.submitEmail(uiState.value.email)
            setLoadingState(false)
            when(forgotPasswordResult){
                is ForgotPasswordResult.Success -> onSuccess()
                is ForgotPasswordResult.Failure -> onFailure()
            }
        }
    }
    private fun setLoadingState(isLoading: Boolean){
        _uiState.update {
            it.copy(isLoading=isLoading)
        }
    }
}
