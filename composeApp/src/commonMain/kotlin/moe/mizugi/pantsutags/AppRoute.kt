package moe.mizugi.pantsutags

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute

@Serializable
abstract class TabRoute : AppRoute {
    abstract val displayName: String
    abstract val icon: ImageVector
}

@Serializable
abstract class SubRoute : AppRoute {
}