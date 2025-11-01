package moe.mizugi.pantsutags

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
abstract class AppRoute(
    val name: String,
) {
    abstract val icon: ImageVector
}