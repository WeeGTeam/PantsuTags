package moe.mizugi.pantsutags.presentation.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import moe.mizugi.pantsutags.imageloader.PantsuImageId
import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.koin.compose.koinInject

@Composable
fun ImageGrid(navigationService: NavigationService = koinInject()) {
    val lazyGridState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(500.dp),
        state = lazyGridState,
        horizontalArrangement = Arrangement.spacedBy(12.dp), // mobile 4.dp
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Text("LazyVerticalGrid")
        }
        items(50, { it }) { index ->
            println("ImageGrid: $index")
            val url = PantsuImageId("testId")
            AsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data(url)
                    .size(1000)
                    .build(),
                contentDescription = "Image $index",
                modifier = Modifier
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,
            )
        }
    }
}