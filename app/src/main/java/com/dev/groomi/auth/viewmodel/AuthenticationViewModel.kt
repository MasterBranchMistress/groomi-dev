package com.dev.groomi.auth.viewmodel

import androidx.lifecycle.ViewModel
import com.dev.groomi.auth.validation.AuthenticationValidator
import com.dev.groomi.shared.validation.ValidationField
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
            it.copy(email = email)
        }
    }

    fun onPasswordChange(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
    }

    fun onLoginClick() {
        val result = AuthenticationValidator.validateLogin(email = uiState.value.email,
            password = uiState.value.password)
        when(result) {
            is ValidationResult.Error -> {

                when(result.field) {

                    ValidationField.EMAIL -> {
                        _uiState.update {
                            it.copy(
                                emailError = result.message
                            )
                        }
                    }

                    ValidationField.PASSWORD -> {
                        _uiState.update {
                            it.copy(
                                passwordError = result.message
                            )
                        }
                    }
                }
            }

            ValidationResult.Success -> {
                //TODO: authenticate with fake Repository
            }
        }
    }
}