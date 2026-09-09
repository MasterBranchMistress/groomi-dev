package com.dev.groomi.auth.dto.change_password

data class ChangePasswordRequest(val token: String?, val newPassword: String)