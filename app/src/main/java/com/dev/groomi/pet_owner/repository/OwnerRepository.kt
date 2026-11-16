package com.dev.groomi.pet_owner.repository

import com.dev.groomi.pet_owner.api.OwnerApi
import com.dev.groomi.pet_owner.dto.owner_summary.read.OwnerSummaryRequest
import com.dev.groomi.shared.local.auth.TokenManager
import com.dev.groomi.shared.utils.parseErrorMessage
import retrofit2.HttpException
import java.io.IOException
import java.util.UUID
import javax.inject.Inject

class OwnerRepository @Inject constructor(
    private val api: OwnerApi,
    private val tokenManager: TokenManager
) : OwnerRepositoryInterface {

    override suspend fun readPetOwner(
        ownerId: UUID?, groomerToken: String
    ): ReadOwnerResult {
        return try {
            //TODO: Update the search bar to dynamically bring up cards.
            //Right now its just a hardcoded UUID string for proof of concept
            val response = api.readPetOwner(
                OwnerSummaryRequest(UUID.fromString("707dcc65-e1d5-4189-8545-5262cc792d8b")

                    , tokenManager.getToken().toString())
            )
            ReadOwnerResult.Success(response)
        } catch (error: HttpException) {
            val errorResponse = parseErrorMessage(error)
            ReadOwnerResult.Failure(errorResponse)
        } catch (error: IOException) {
            ReadOwnerResult.Failure(
                "Network Unavailable. Check your internet connection and try again."
            )
        }

    }
}

