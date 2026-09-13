package moe.mizugi.pantsutags.presentation.import

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.composeunstyled.Text
import moe.mizugi.pantsutags.api.repository.ImageRepository
import org.koin.compose.koinInject

@Composable
fun ImportScreen(
    imageRepository: ImageRepository = koinInject(),
) {
    var imageIds by remember { mutableStateOf<List<String>>(listOf()) }
    LaunchedEffect(Unit) {
        val result = imageRepository.getImages();
        imageIds = result.getOrElse { listOf() }
    }

    Column {
        Text("Import")
        Text("Image ids:")
        for (id in imageIds) {
            Text(id)
        }
    }
}
