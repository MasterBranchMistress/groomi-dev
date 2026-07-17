package com.dev.groomi.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.groomi.auth.feedback.LoginErrorMessages
import com.dev.groomi.auth.repository.login.LoginRepositoryInterface
import com.dev.groomi.auth.repository.login.LoginResult
import com.dev.groomi.auth.validation.fields.AuthenticationFields
import com.dev.groomi.auth.validation.validators.AuthenticationValidator
import com.dev.groomi.shared.validation.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AuthenticationUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null,
    val loginError: LoginErrorMessages? = null
)

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepositoryInterface): ViewModel() {

    private val _uiState = MutableStateFlow(AuthenticationUiState())
    val uiState: StateFlow<AuthenticationUiState> = _uiState.asStateFlow()
    fun onEmailChange(email: String) {
        _uiState.update {
            it.copy(email = email,
                emailError = null)
        }
    }
    fun onPasswordChange(password: String) {
        _uiState.update {
            it.copy(password = password,
                passwordError = null)
        }
    }
     fun onLoginClick(onSuccess: () -> Unit, onFailure:(String) -> Unit) {
        val result = AuthenticationValidator.validateLogin(email = uiState.value.email,
            password = uiState.value.password)
        when(result) {
            is ValidationResult.Error<AuthenticationFields> -> {
                updateValidationError(result)
            }
            ValidationResult.Success -> {
                viewModelScope.launch {
                    setLoadingState(true)
                    val loginResult =  repository.login(uiState.value.email, uiState.value.password)
                    setLoadingState(false)
                    when(loginResult){
                        is LoginResult.Success -> onSuccess()
                        is LoginResult.Failure -> onFailure(loginResult.message)
                    }
                }
            }
        }
    }
    private fun updateValidationError(error: ValidationResult.Error<AuthenticationFields>) {
        _uiState.update {
            when (error.field) {
                AuthenticationFields.EMAIL ->
                    it.copy(emailError = error.message)

                AuthenticationFields.PASSWORD ->
                    it.copy(passwordError = error.message)
            }
        }
    }

    private fun setLoadingState(isLoading: Boolean){
        _uiState.update {
            it.copy(isLoading=isLoading)
        }
    }
}