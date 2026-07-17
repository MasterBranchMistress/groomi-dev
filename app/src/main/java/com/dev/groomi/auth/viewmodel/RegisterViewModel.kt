package com.dev.groomi.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.groomi.auth.feedback.RegisterErrorMessages
import com.dev.groomi.auth.repository.register.RegisterRepositoryInterface
import com.dev.groomi.auth.repository.register.RegisterResult
import com.dev.groomi.auth.validation.fields.RegistrationFields
import com.dev.groomi.auth.validation.validators.RegistrationValidator
import com.dev.groomi.shared.validation.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RegisterUiState(val firstName: String="",
                           val lastName: String="",
                           val email: String="",
                           val phoneNumber:String="",
                           val password: String="",
                           val confirmPassword:String="",
                           val firstNameError: String?=null,
                           val lastNameError: String?=null,
                           val emailError: String?=null,
                           val phoneNumberError: String?=null,
                           val passwordError: String?=null,
                           val isLoading: Boolean=false,
    )

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: RegisterRepositoryInterface): ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()
    fun onFirstNameChange(firstName: String) {
        _uiState.update {
            it.copy(firstName = firstName,
                    firstNameError = null
            )
        }
    }
    fun onLastNameChange(lastName: String) {
        _uiState.update {
            it.copy(lastName = lastName,
                lastNameError = null)
        }
    }
    fun onEmailChange(email:String) {
        _uiState.update {
            it.copy(email = email,
                emailError = null)
        }
    }
    fun onPhoneNumberChange(phoneNumber: String) {
        _uiState.update {
            it.copy(phoneNumber = phoneNumber,
                phoneNumberError = null)
        }
    }
    fun onPasswordChange(password: String) {
        _uiState.update {
            it.copy(password = password,
                passwordError = null)
        }
    }
        fun onConfirmPasswordChange(confirmPassword: String) {
            _uiState.update {
                it.copy(confirmPassword = confirmPassword)
            }
        }
             fun onRegisterClick(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
                val validationResult = RegistrationValidator.validateRegistration(
                    firstName = uiState.value.firstName,
                    lastName = uiState.value.lastName,
                    email = uiState.value.email,
                    phoneNumber = uiState.value.phoneNumber,
                    password = uiState.value.password,
                    confirmPassword = uiState.value.confirmPassword
                    )
                when(validationResult){
                    is ValidationResult.Error<RegistrationFields> -> {
                        updateValidationError(validationResult)
                    }
                    ValidationResult.Success -> {
                        viewModelScope.launch {
                            setLoadingState(true)
                            val registerResult = repository.register(firstName = uiState.value.firstName,
                                lastName = uiState.value.lastName,
                                email = uiState.value.email,
                                phoneNumber = uiState.value.phoneNumber,
                                password = uiState.value.password,
                                confirmPassword = uiState.value.confirmPassword)
                            setLoadingState(false)
                            when(registerResult){
                                is RegisterResult.Success -> onSuccess()
                                is RegisterResult.Failure -> onFailure(registerResult.message)
                            }
                        }
                    }
                }
            }
    private fun updateValidationError(error: ValidationResult.Error<RegistrationFields>) {
        _uiState.update {
            when (error.field) {
                RegistrationFields.FIRST_NAME ->
                    it.copy(firstNameError = error.message)

                RegistrationFields.LAST_NAME ->
                    it.copy(lastNameError = error.message)

                RegistrationFields.EMAIL ->
                    it.copy(emailError = error.message)

                RegistrationFields.PHONE_NUMBER ->
                    it.copy(phoneNumberError = error.message)

                RegistrationFields.PASSWORD ->
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