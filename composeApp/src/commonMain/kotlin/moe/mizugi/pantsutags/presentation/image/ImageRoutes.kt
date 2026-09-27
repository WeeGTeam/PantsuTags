package moe.mizugi.pantsutags.presentation.image

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.mizugi.pantsutags.SubRoute

@Serializable
@SerialName("image-view")
class ImageViewDestination(val imageId: String) : SubRoute()


fun NavGraphBuilder.imageRoutes() {
    composable<ImageViewDestination> { ImageScreen() }
}
