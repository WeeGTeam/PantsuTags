package moe.mizugi.pantsutags.presentation.import

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.composeunstyled.Text
import moe.mizugi.pantsutags.api.repository.PantsuServerRepository
import org.koin.compose.koinInject

@Composable
fun ImportScreen(
    pantsuServerRepository: PantsuServerRepository = koinInject(),
) {
    var imageIds by remember { mutableStateOf<List<String>>(listOf()) }
    LaunchedEffect(Unit) {
        val result = pantsuServerRepository.getImages();
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
