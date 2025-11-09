package moe.mizugi.pantsutags.presentation.image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.koin.compose.koinInject


@Composable
fun ImageScreen(
    imageViewDestination: ImageViewDestination,
    navigationService: NavigationService = koinInject()
) {
    val url = imageViewDestination.url
    Column {
        Text("Image")
        Button(onClick = {
            navigationService.navigateBack()
        }) {
            Text("Back")
        }
        AsyncImage(
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(url)
                .memoryCacheKey(url)
                .diskCacheKey(url)
                .size(1000)
                .build(),
            contentDescription = "Image 1",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
        )
    }
}