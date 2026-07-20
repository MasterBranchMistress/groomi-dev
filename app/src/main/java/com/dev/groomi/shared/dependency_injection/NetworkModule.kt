package com.dev.groomi.shared.dependency_injection

import android.content.Context
import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.repository.login.LoginRepository
import com.dev.groomi.auth.repository.login.LoginRepositoryInterface
import com.dev.groomi.auth.repository.register.RegisterRepository
import com.dev.groomi.auth.repository.register.RegisterRepositoryInterface
import com.dev.groomi.shared.local.auth.AuthInterceptor
import com.dev.groomi.shared.local.auth.TokenManager
import com.dev.groomi.shared.network.NetworkConstants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideTokenManager(
        @ApplicationContext context: Context
    ): TokenManager =
        TokenManager(context)

    @Provides
    @Singleton
    fun AuthInterceptor(
        tokenManager: TokenManager
    ): AuthInterceptor = AuthInterceptor(tokenManager
    )
    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAuthenticationApi(
        retrofit: Retrofit
    ): AuthenticationApi =
        retrofit.create(AuthenticationApi::class.java)
}