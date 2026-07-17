package com.dev.groomi.auth.feedback

sealed class LoginErrorMessages(
    val message: String
) {
    data object InvalidCredentials :
        LoginErrorMessages("Invalid email or password")

    data object NetworkFailure :
        LoginErrorMessages("Unable to connect. Please check your connection and try again.")

    data object Unknown :
        LoginErrorMessages("Something went wrong.")

    companion object {
        fun fromType(errorType: String): LoginErrorMessages {
            return when(errorType) {
                "INVALID_CREDENTIALS" -> InvalidCredentials
                "NETWORK_FAILURE" -> NetworkFailure
                else -> Unknown
            }
        }
    }
}