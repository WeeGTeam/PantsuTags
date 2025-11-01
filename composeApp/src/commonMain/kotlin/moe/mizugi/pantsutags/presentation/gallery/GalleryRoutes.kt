package moe.mizugi.pantsutags.presentation.gallery

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import moe.mizugi.pantsutags.AppRoute

@Serializable
object GalleryDestination : AppRoute("Gallery") {
    override val icon: ImageVector = Icons.Default.PhotoLibrary
}

fun NavGraphBuilder.galleryRoutes() {
    composable<GalleryDestination> { GalleryScreen() }
}