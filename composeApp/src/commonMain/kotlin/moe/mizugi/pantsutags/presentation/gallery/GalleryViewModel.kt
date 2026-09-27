package moe.mizugi.pantsutags.presentation.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import moe.mizugi.pantsutags.api.repository.ImageRepository

sealed interface GalleryUiState {
    data object Loading : GalleryUiState
    data class Loaded(val imageIds: List<String>) : GalleryUiState
    data class Error(val message: String) : GalleryUiState
}

class GalleryViewModel(
    private val imageRepository: ImageRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow<GalleryUiState>(GalleryUiState.Loading)
    val uiState: StateFlow<GalleryUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _uiState.value = GalleryUiState.Loading
            _uiState.value = imageRepository.getImages().fold(
                onSuccess = { GalleryUiState.Loaded(it) },
                onFailure = { GalleryUiState.Error(it.message ?: "Unknown error") },
            )
        }
    }
}
