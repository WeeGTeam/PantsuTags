package moe.mizugi.pantsutags.presentation.gallery

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import moe.mizugi.pantsutags.api.repository.ImageRepository
import org.koin.compose.koinInject

@Composable
fun GalleryScreen(
    imageRepository: ImageRepository = koinInject(),
) {
    var imageIds by rememberSaveable { mutableStateOf<List<String>?>(null) }
    LaunchedEffect(Unit) {
        if (imageIds == null) {
            val result = imageRepository.getImages();
            imageIds = result.getOrElse { listOf() }
        }
    }

    imageIds?.let {
        ImageGrid(it)
    }
}
