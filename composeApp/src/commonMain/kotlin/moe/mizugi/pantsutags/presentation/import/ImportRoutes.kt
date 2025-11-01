package moe.mizugi.pantsutags.presentation.import

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import moe.mizugi.pantsutags.AppRoute

@Serializable
object ImportDestination : AppRoute("Import") {
    override val icon: ImageVector = Icons.Default.AddPhotoAlternate
}

fun NavGraphBuilder.importRoutes() {
    composable<ImportDestination> { ImportScreen() }
}