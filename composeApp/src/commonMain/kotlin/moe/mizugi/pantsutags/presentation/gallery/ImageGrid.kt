package moe.mizugi.pantsutags.presentation.gallery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import com.composeunstyled.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import moe.mizugi.pantsutags.api.repository.ImageDownloadRepository
import moe.mizugi.pantsutags.presentation.image.ImageViewDestination
import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.koin.compose.koinInject

@Composable
fun ImageGrid(
    imageIds: List<String>,
    imageDownloadRepository: ImageDownloadRepository = koinInject(),
    navigationService: NavigationService = koinInject(),
) {
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
        items(imageIds.size, { imageIds[it] }) { index ->
            val imageId = imageIds[index]
            println("ImageGrid: index: $index, ImageId: $imageId")
            val thumbnailUrl = imageDownloadRepository.getThumbnailImageUrl(imageId)
            AsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data(thumbnailUrl)
                    .memoryCacheKey(thumbnailUrl)
                    .diskCacheKey(thumbnailUrl)
                    .size(1000)
                    .build(),
                contentDescription = "Image $imageId",
                modifier = Modifier
                    .aspectRatio(1f)
                    .clickable(
                        interactionSource = null,
                        indication = null,
                        onClick = {
                            navigationService.navigateTo(
                                ImageViewDestination(
                                    imageDownloadRepository.getImageUrl(imageId)
                                )
                            )
                        },
                    ),
                contentScale = ContentScale.Crop,
            )
        }
    }
}
