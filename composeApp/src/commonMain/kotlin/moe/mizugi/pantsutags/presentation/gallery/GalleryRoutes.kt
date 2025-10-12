package moe.mizugi.pantsutags.presentation.gallery

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import moe.mizugi.pantsutags.AppRoute

@Serializable
object GalleryDestination: AppRoute()

fun NavGraphBuilder.galleryRoutes() {
    composable<GalleryDestination> { GalleryScreen() }
}