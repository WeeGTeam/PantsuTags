package moe.mizugi.pantsutags.presentation.image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.composeunstyled.Text
import moe.mizugi.pantsutags.presentation.components.KaniButton
import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun ImageScreen(
    imageViewModel: ImageViewModel = koinViewModel(),
    navigationService: NavigationService = koinInject()
) {
    val url = imageViewModel.imageUrl
    Column {
        Text("Image")
        KaniButton(onClick = {
            navigationService.navigateBack()
        }) {
            Text("Back")
        }
        AsyncImage(
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(url)
                .memoryCacheKey(url)
                .diskCacheKey(url)
                .build(),
            contentDescription = "Image ${imageViewModel.imageId}",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
        )
    }
}
