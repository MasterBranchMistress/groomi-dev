package com.dev.groomi.auth.register.test_utils

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.repository.register.RegisterRepository
import com.dev.groomi.auth.viewmodel.RegisterViewModel
import org.mockito.kotlin.mock

data class RegisterTestSetup(
    val repository: RegisterRepository,
    val api: AuthenticationApi,
    val viewModel: RegisterViewModel
)

fun createRegisterTestSetup(): RegisterTestSetup {
    val api = mock<AuthenticationApi>()

    val repository = RegisterRepository(
        api
    )
    val viewModel = RegisterViewModel(repository)

    return RegisterTestSetup(
        repository = repository,
        api = api,
        viewModel =  viewModel,
    )
}