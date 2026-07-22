package com.dev.groomi.auth.login.test_utils

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.repository.login.FakeLoginRepository
import com.dev.groomi.auth.repository.login.LoginRepository
import com.dev.groomi.auth.repository.login.LoginRepositoryInterface
import com.dev.groomi.auth.viewmodel.LoginViewModel
import com.dev.groomi.shared.local.auth.TokenManager
import org.mockito.kotlin.mock

data class LoginTestSetup(
    val repository: LoginRepository,
    val api: AuthenticationApi,
    val tokenManager: TokenManager,
    val viewModel: LoginViewModel
)

fun createLoginTestSetup(): LoginTestSetup {
    val api = mock<AuthenticationApi>()
    val tokenManager = mock<TokenManager>()

    val repository = LoginRepository(
        api,
        tokenManager
    )
    val viewModel = LoginViewModel(repository)

    return LoginTestSetup(
        repository = repository,
        api = api,
        tokenManager = tokenManager,
        viewModel =  viewModel,
    )
}