package moe.mizugi.pantsutags.presentation.image

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import moe.mizugi.pantsutags.api.repository.ImageDownloadRepository

class ImageViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val imageDownloadRepository: ImageDownloadRepository,
) : ViewModel() {
    private val destination: ImageViewDestination = savedStateHandle.toRoute<ImageViewDestination>()
    val imageId: String = destination.imageId
    val imageUrl: String = imageDownloadRepository.getImageUrl(imageId)
}
