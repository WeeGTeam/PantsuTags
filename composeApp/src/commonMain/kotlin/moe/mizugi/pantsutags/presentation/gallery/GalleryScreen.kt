package moe.mizugi.pantsutags.presentation.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.composeunstyled.Text
import moe.mizugi.pantsutags.presentation.components.KaniButton
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GalleryScreen(
    viewModel: GalleryViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    GalleryContent(uiState, reload = viewModel::load)
}

@Composable
private fun GalleryContent(
    uiState: GalleryUiState,
    reload: () -> Unit,
) {
    when (uiState) {
        GalleryUiState.Loading -> Text("Loading…")
        is GalleryUiState.Loaded -> ImageGrid(uiState.imageIds)
        is GalleryUiState.Error -> Column {
            Text("Could not load images: ${uiState.message}")
            KaniButton(onClick = reload) {
                Text("Retry")
            }
        }
    }
}
