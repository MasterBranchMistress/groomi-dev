package com.dev.groomi.shared.network

data class ErrorResponse(
    val statusCode: Int,
    val type: String?,
    val message: String?,
    val timestamp: String?
)