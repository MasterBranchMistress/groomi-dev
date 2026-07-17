package com.dev.groomi.auth.repository.register

import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.register.RegisterRequest
import com.dev.groomi.shared.utils.parseErrorMessage
import retrofit2.HttpException
import javax.inject.Inject

class RegisterRepository @Inject constructor(private val api: AuthenticationApi):
    RegisterRepositoryInterface{
    override suspend fun register(
        firstName: String,
        lastName: String,
        phoneNumber: String,
        email: String,
        password: String,
        confirmPassword: String
    ): RegisterResult {
        return try {
               api.register(
                RegisterRequest(
                    firstName=firstName,
                    lastName=lastName,
                    email=email,
                    phoneNumber=phoneNumber,
                    password=password
                )
            )
            RegisterResult.Success
        } catch (error: HttpException){
            RegisterResult.Failure(parseErrorMessage(error))
        }
    }

}

