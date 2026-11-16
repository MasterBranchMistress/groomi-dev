package com.dev.groomi.pet_owner.repository

import com.dev.groomi.pet_owner.dto.owner_summary.read.OwnerSummaryResponse
import com.dev.groomi.shared.network.ApiResponse
import java.util.UUID

sealed interface ReadOwnerResult{

    data class Success(
        val data: ApiResponse<OwnerSummaryResponse>
    ): ReadOwnerResult
    data class Failure(val message: String): ReadOwnerResult
}

interface OwnerRepositoryInterface {
    suspend fun readPetOwner(ownerId: UUID?, groomerToken: String): ReadOwnerResult
}

