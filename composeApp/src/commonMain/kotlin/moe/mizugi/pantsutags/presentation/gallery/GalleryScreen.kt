package moe.mizugi.pantsutags.presentation.gallery

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import moe.mizugi.pantsutags.api.repository.ImageListRepository
import org.koin.compose.koinInject

@Composable
fun GalleryScreen(
    imageListRepository: ImageListRepository = koinInject(),
) {
    var imageIds by rememberSaveable { mutableStateOf<List<String>?>(null) }
    LaunchedEffect(Unit) {
        if (imageIds == null) {
            val result = imageListRepository.getImages();
            imageIds = result.getOrElse { listOf() }
        }
    }

    imageIds?.let {
        ImageGrid(it)
    }
}
