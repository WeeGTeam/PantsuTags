package moe.mizugi.pantsutags.presentation.import

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.composeunstyled.Text
import moe.mizugi.pantsutags.api.repository.ImageListRepository
import org.koin.compose.koinInject

@Composable
fun ImportScreen(
    imageListRepository: ImageListRepository = koinInject(),
) {
    var imageIds by remember { mutableStateOf<List<String>>(listOf()) }
    LaunchedEffect(Unit) {
        val result = imageListRepository.getImages();
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
