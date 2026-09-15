package com.dev.groomi.auth.reset_password.test_utils

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.repository.change_password.ChangePasswordRepository
import com.dev.groomi.auth.viewmodel.ResetPasswordViewModel

import com.dev.groomi.shared.local.auth.TokenManager
import org.mockito.kotlin.mock

data class ResetPasswordTestSetup(
val repository: ChangePasswordRepository,
val api: AuthenticationApi,
val tokenManager: TokenManager,
val viewModel: ResetPasswordViewModel
)

fun createResetPasswordTestSetup(): ResetPasswordTestSetup{
    val api = mock<AuthenticationApi>()
    val tokenManager = mock<TokenManager>()

    val repository = ChangePasswordRepository(
    api
    )

    val viewModel = ResetPasswordViewModel(repository)

    return ResetPasswordTestSetup(
        repository = repository,
    api = api,
    tokenManager = tokenManager,
    viewModel = viewModel
    )
}