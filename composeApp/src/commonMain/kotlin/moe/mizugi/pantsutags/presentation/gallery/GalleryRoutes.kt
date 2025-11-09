package moe.mizugi.pantsutags.presentation.gallery

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.mizugi.pantsutags.TabRoute

@Serializable
@SerialName("gallery")
class GalleryDestination() : TabRoute() {
    override val displayName: String = DISPLAY_NAME
    override val icon: ImageVector get() = ICON

    companion object {
        const val DISPLAY_NAME: String = "Gallery"
        val ICON: ImageVector = Icons.Default.PhotoLibrary
    }
}

fun NavGraphBuilder.galleryRoutes() {
    composable<GalleryDestination> { GalleryScreen() }
}