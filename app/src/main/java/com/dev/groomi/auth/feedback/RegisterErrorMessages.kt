package com.dev.groomi.auth.feedback

sealed class RegisterErrorMessages(val message: String) {
    data object NetworkFailure:
        RegisterErrorMessages("Unable to connect. Please check your connection and try again.")
    data object UnknownError:
        RegisterErrorMessages("Something went wrong. Unable to register.")

}