package com.dev.groomi.auth.viewmodel

import androidx.lifecycle.ViewModel
import com.dev.groomi.auth.validation.fields.AuthenticationFields
import com.dev.groomi.auth.validation.validators.AuthenticationValidator
import com.dev.groomi.shared.validation.ValidationResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class AuthenticationUiState(val email: String = "",
                                 val password: String = "",
                                 val isLoading: Boolean=false,
                                 val emailError: String?=null,
                                 val passwordError: String?=null
    )

class AuthenticationViewModel : ViewModel() {

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

    fun onLoginClick() {
        val result = AuthenticationValidator.validateLogin(email = uiState.value.email,
            password = uiState.value.password)
        when(result) {
            is ValidationResult.Error<AuthenticationFields> -> {
                updateValidationError(result)
            }

            ValidationResult.Success -> {
                //TODO: authenticate with fake Repository
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
}