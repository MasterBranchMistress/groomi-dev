package com.dev.groomi.di

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.repository.login.LoginRepository
import com.dev.groomi.auth.repository.login.LoginRepositoryInterface
import com.dev.groomi.auth.repository.register.RegisterRepository
import com.dev.groomi.auth.repository.register.RegisterRepositoryInterface
import com.dev.groomi.shared.network.NetworkConstants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAuthenticationApi(
        retrofit: Retrofit
    ): AuthenticationApi =
        retrofit.create(AuthenticationApi::class.java)

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
}