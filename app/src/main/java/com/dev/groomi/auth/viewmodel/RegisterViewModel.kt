package com.dev.groomi.auth.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class RegisterUiState(val firstName: String="",
                           val lastName: String="",
                           val email: String="",
                           val phoneNumber:String="",
                           val password: String="",
                           val confirmPassword:String="")

class RegisterViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun onFirstNameChange(firstName: String) {
        _uiState.update {
            it.copy(firstName = firstName)
        }
    }

    fun onLastNameChange(lastName: String) {
        _uiState.update {
            it.copy(lastName = lastName)
        }
    }
    fun onEmailChange(email:String) {
        _uiState.update {
            it.copy(email = email)
        }
    }
    fun onPhoneNumberChange(phoneNumber: String) {
        _uiState.update {
            it.copy(phoneNumber = phoneNumber)
        }
    }

    fun onPasswordChange(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
    }

        fun onConfirmPasswordChange(confirmPassword: String) {
            _uiState.update {
                it.copy(confirmPassword = confirmPassword)
            }
        }
            fun onRegisterClick() {
                // TODO: Register to Repository
            }
        }