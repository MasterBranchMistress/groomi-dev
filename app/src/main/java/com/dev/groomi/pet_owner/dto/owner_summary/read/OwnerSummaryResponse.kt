package com.dev.groomi.pet_owner.dto.owner_summary.read

import java.util.UUID

data class OwnerSummaryResponse(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
   val email: String,
    val petOwnerPhotoUrl: String,
    val groomerId: UUID
)

