package com.dev.groomi.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.groomi.auth.repository.change_password.ChangePasswordRepository
import com.dev.groomi.auth.repository.change_password.ChangePasswordResult
import com.dev.groomi.auth.validation.fields.ResetPasswordFields
import com.dev.groomi.auth.validation.validators.ResetPasswordValidator
import com.dev.groomi.shared.validation.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ResetPasswordUiState(
    val password: String = "",
    val confirmPassword: String = "",
    val passwordError: String? = null,
    val confirmPasswordError: String? = null,
    var isLoading: Boolean = false,
)

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(
    private val repository: ChangePasswordRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ResetPasswordUiState())
    val uiState: StateFlow<ResetPasswordUiState> = _uiState.asStateFlow()

    private var token: String? = null

    fun setToken(token: String?) {
        this.token = token
    }

    fun onPasswordChange(password: String) {
        _uiState.update {
            it.copy(
                password = password,
                passwordError = null
            )
        }
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        _uiState.update {
            it.copy(
                confirmPassword = confirmPassword,
                confirmPasswordError = null
            )
        }
    }

    fun onChangePasswordClick(
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        val state = uiState.value

        when (
            val validationResult = ResetPasswordValidator.validate(
                password = state.password,
                confirmPassword = state.confirmPassword
            )
        ) {
            ValidationResult.Success -> {
                viewModelScope.launch {
                    setLoadingState(true)

                    val changePasswordResult = repository.changePassword(
                        token = token,
                        password = state.password
                    )

                    setLoadingState(false)

                    when (changePasswordResult) {
                        is ChangePasswordResult.Success -> {
                            onSuccess()
                        }

                        is ChangePasswordResult.Failure -> {
                            onFailure(changePasswordResult.message)
                        }
                    }
                }
            }

            is ValidationResult.Error -> {
                updateValidationError(validationResult)
            }
        }
    }

    private fun updateValidationError(
        error: ValidationResult.Error<ResetPasswordFields>
    ) {
        _uiState.update {
            when (error.field) {
                ResetPasswordFields.PASSWORD ->
                    it.copy(passwordError = error.message)

                ResetPasswordFields.CONFIRM_PASSWORD ->
                    it.copy(confirmPasswordError = error.message)
            }
        }
    }

    private fun setLoadingState(isLoading: Boolean) {
        _uiState.update {
            it.copy(isLoading = isLoading)
        }
    }
}