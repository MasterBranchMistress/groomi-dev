package com.dev.groomi.pet_owner.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dev.groomi.pet_owner.viewmodel.OwnerSummaryUiState
import com.dev.groomi.shared.ui.components.buttons.GroomiTextButton
import com.dev.groomi.shared.ui.components.cards.SummaryCard
import com.dev.groomi.shared.ui.components.cards.SummaryDetail

@Composable
fun OwnerSummaryCard(
    ownerSummaryUiState: OwnerSummaryUiState,
    onEditClick: () -> Unit,
    onMessageClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Column {
        SummaryCard(
            title = "${ownerSummaryUiState.ownerFirstName} ${ownerSummaryUiState.ownerLastName}",
            photoUrl = ownerSummaryUiState.ownerPhotoUrl,
            subtitle = "Pet Owner",
            details = listOf(
                SummaryDetail(
                    label = "Email",
                    value = ownerSummaryUiState.ownerEmail
                ),
                SummaryDetail(
                    label = "Phone",
                    value = ownerSummaryUiState.ownerPhoneNumber
                )
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            GroomiTextButton(
                buttonText = "Edit",
                onClick = onEditClick
            )

            GroomiTextButton(
                buttonText = "Message",
                onClick = onMessageClick
            )

            GroomiTextButton(
                buttonText = "Delete",
                onClick = onDeleteClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OwnerSummaryCardPreview() {
    OwnerSummaryCard(
        ownerSummaryUiState = OwnerSummaryUiState(
            ownerFirstName = "Jimmie",
            ownerLastName = "Smith",
            ownerEmail = "j.smith@customer.com",
            ownerPhoneNumber = "777-777-7777",
            ownerPhotoUrl = "https://images.unsplash.com/photo-1594283255808-ee728c775ba6"
        ),
        onEditClick = {},
        onMessageClick = {},
        onDeleteClick = {}
    )
}