package com.dev.groomi.auth.repository.account_verification
import com.dev.groomi.auth.api.AuthenticationApi
import com.dev.groomi.auth.dto.verify_account.PendingAccountVerificationRequest
import com.dev.groomi.auth.feedback.LoginErrorMessages
import com.dev.groomi.shared.utils.parseErrorMessage
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


sealed interface PendingAccountVerificationResult{
    data object Success: PendingAccountVerificationResult
    data class Failure(val message: String): PendingAccountVerificationResult
}
class PendingAccountVerificationRepository @Inject constructor(
    private val api: AuthenticationApi
) : PendingAccountVerificationRepositoryInterface {

    override suspend fun verifyAccount(
        token: String
    ): PendingAccountVerificationResult {
        return try {
            api.verifyAccount(
                PendingAccountVerificationRequest(token = token)
            )
            PendingAccountVerificationResult.Success
        } catch (error: HttpException) {
            val errorResponse = parseErrorMessage(error)
            PendingAccountVerificationResult.Failure(errorResponse)
        } catch (error: IOException) {
            PendingAccountVerificationResult.Failure(
                LoginErrorMessages.fromType("NETWORK_FAILURE").toString()
            )
        }
    }
}