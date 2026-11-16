package com.dev.groomi.pet_owner.api

import com.dev.groomi.pet_owner.dto.owner_summary.read.OwnerSummaryRequest
import com.dev.groomi.pet_owner.dto.owner_summary.read.OwnerSummaryResponse
import com.dev.groomi.shared.network.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface OwnerApi {

    @POST("pet-owner/read-pet-owner")
    suspend fun readPetOwner(
        @Body request: OwnerSummaryRequest
    ): ApiResponse<OwnerSummaryResponse>
}