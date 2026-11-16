package com.dev.groomi.pet_owner.dto.owner_summary.read

import java.util.UUID

data class OwnerSummaryRequest (val ownerId: UUID?, val groomerToken: String)


