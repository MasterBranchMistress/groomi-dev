package com.dev.groomi.auth.repository.change_password
interface ChangePasswordRepositoryInterface {
    suspend fun changePassword(
        token: String?,
        password: String
    ): ChangePasswordResult
}