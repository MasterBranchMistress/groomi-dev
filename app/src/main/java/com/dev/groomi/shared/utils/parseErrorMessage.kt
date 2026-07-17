package com.dev.groomi.shared.utils

import android.util.Log
import com.dev.groomi.shared.network.ErrorResponse
import com.google.gson.Gson
import retrofit2.HttpException

fun parseErrorMessage(exception: HttpException): String {
    val body = exception.response()
        ?.errorBody()
        ?.string()

    return try {
         Gson().fromJson(body, ErrorResponse::class.java)
            ?.message
            ?: "Unknown server error"

    } catch (error: Exception) {
        "Something went wrong: ${error.message}"
    }
}