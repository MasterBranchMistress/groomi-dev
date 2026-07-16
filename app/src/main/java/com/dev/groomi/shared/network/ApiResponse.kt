package com.dev.groomi.shared.network

data class ApiResponse<T>(
    val message: String,
    val data: T,
    val timestamp: String
)