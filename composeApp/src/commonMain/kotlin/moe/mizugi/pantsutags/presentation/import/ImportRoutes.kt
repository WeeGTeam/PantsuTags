package moe.mizugi.pantsutags.presentation.import

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import moe.mizugi.pantsutags.AppRoute

@Serializable
object ImportDestination: AppRoute()

fun NavGraphBuilder.importRoutes() {
    composable<ImportDestination> { ImportScreen() }
}