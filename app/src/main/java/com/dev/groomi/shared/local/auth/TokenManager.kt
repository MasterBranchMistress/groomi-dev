package com.dev.groomi.shared.local.auth

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlin.text.get

@Singleton
class TokenManager @Inject constructor(
    @param: ApplicationContext private val context: Context
) {

    companion object {
        private val Context.dataStore by preferencesDataStore(name = "auth_prefs")
        private val ACCESS_TOKEN_KEY = stringPreferencesKey("jwt_access_token")
    }

    val accessToken: Flow<String?> = context.dataStore.data
        .map { preferences -> preferences[ACCESS_TOKEN_KEY] }

    suspend fun saveToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN_KEY] = token
        }
    }

    suspend fun clearToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(ACCESS_TOKEN_KEY)
        }
    }
    suspend fun getToken(): String? =
        accessToken.first()
}