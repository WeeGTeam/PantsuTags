package moe.mizugi.pantsutags

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.StringResource

@Serializable
sealed interface AppRoute

@Serializable
abstract class TabRoute : AppRoute {
    abstract val displayName: StringResource
    abstract val icon: ImageVector
}

@Serializable
abstract class SubRoute : AppRoute {
}