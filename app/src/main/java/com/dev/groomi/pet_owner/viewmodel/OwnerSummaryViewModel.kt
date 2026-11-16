package com.dev.groomi.pet_owner.viewmodel

import com.dev.groomi.pet_owner.repository.OwnerRepository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.groomi.pet_owner.repository.ReadOwnerResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

data class OwnerSummaryUiState(
    val ownerId: UUID? = null,
    val groomerToken: String = "",
    val isLoading: Boolean = false,
    val ownerFirstName: String = "",
    val ownerLastName: String = "",
    val ownerPhoneNumber: String = "",
    val ownerEmail: String = "",
    val ownerPhotoUrl: String = "",
    val error: String = ""
)

@HiltViewModel
class OwnerSummaryViewModel @Inject constructor(
    private val repository: OwnerRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(OwnerSummaryUiState())
    val uiState: StateFlow<OwnerSummaryUiState> = _uiState.asStateFlow()

    fun loadPetOwnerInformation() {
        viewModelScope.launch {
            when (val result = repository.readPetOwner(uiState.value.ownerId, uiState.value.groomerToken)) {
                is ReadOwnerResult.Success -> {
                    val owner = result.data.data
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            ownerFirstName = owner.firstName,
                            ownerLastName = owner.lastName,
                            ownerEmail = owner.email,
                            ownerPhoneNumber = owner.phoneNumber,
                            ownerPhotoUrl = owner.petOwnerPhotoUrl,
                            error = ""
                        )
                    }
                }

                is ReadOwnerResult.Failure -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }

    private fun setLoadingState(isLoading: Boolean) {
        _uiState.update {
            it.copy(isLoading = isLoading)
        }
    }
}

