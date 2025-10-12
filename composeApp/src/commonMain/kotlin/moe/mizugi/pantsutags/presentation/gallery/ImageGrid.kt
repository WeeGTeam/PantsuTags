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

@Composable
fun ImageGrid() {
    val lazyGridState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        state = lazyGridState,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Text("LazyVerticalGrid")
        }
        items(50, { it }) { index ->
            println("ImageGrid: $index")
            val url = when (index % 5) {
                0 -> "https://cdn.donmai.us/original/29/e8/__rurudo_lion_indie_virtual_youtuber_drawn_by_yunmi_0527__29e8eaf6b6e57927134b4fb21e5816d6.jpg"
                1 -> "https://img4.gelbooru.com//samples/47/15/sample_47159a3160887bf69236433c9803fe87.jpg"
                2 -> "https://img4.gelbooru.com//samples/a2/c8/sample_a2c8d0087f224ce5e36aa55de21c2588.jpg"
                3 -> "https://img4.gelbooru.com//samples/09/a4/sample_09a411e7be3cece43c644fd792a64f13.jpg"
                else -> "https://img4.gelbooru.com//images/81/fb/81fb01d5dfac52340a406e6622178176.png"
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data(url)
                    .memoryCacheKey(url)
                    .diskCacheKey(url)
                    .size(1000)
                    .build(),
                contentDescription = "Image $index",
                modifier = Modifier.aspectRatio(1f),
                contentScale = ContentScale.Crop,
            )
        }
    }
}