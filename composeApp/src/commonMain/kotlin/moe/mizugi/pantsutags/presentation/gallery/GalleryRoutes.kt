package moe.mizugi.pantsutags.presentation.gallery

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.mizugi.pantsutags.TabRoute
import org.jetbrains.compose.resources.StringResource
import pantsutags.composeapp.generated.resources.Res
import pantsutags.composeapp.generated.resources.tab_route_name_gallery

@Serializable
@SerialName("gallery")
class GalleryDestination() : TabRoute() {
    override val displayName: StringResource get() = DISPLAY_NAME
    override val icon: ImageVector get() = ICON

    companion object {
        val DISPLAY_NAME: StringResource = Res.string.tab_route_name_gallery
        val ICON: ImageVector = Icons.Default.PhotoLibrary
    }
}

fun NavGraphBuilder.galleryRoutes() {
    composable<GalleryDestination> { GalleryScreen() }
}