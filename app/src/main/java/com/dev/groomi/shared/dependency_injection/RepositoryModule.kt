package com.dev.groomi.shared.dependency_injection

import com.dev.groomi.auth.repository.login.LoginRepository
import com.dev.groomi.auth.repository.login.LoginRepositoryInterface
import com.dev.groomi.auth.repository.register.RegisterRepository
import com.dev.groomi.auth.repository.register.RegisterRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLoginRepository(
        repository: LoginRepository
    ): LoginRepositoryInterface
    @Binds
    abstract fun bindRegisterRepository(
        repository: RegisterRepository
    ): RegisterRepositoryInterface
}