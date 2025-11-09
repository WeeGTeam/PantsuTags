package moe.mizugi.pantsutags.presentation.image

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.mizugi.pantsutags.SubRoute

@Serializable
@SerialName("image-view")
class ImageViewDestination(val url: String) : SubRoute()


fun NavGraphBuilder.imageRoutes() {
    composable<ImageViewDestination> { backStackEntry ->
        val destination = backStackEntry.toRoute<ImageViewDestination>()
        ImageScreen(destination)
    }
}