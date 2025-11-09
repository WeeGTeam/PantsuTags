package moe.mizugi.pantsutags.presentation.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.mizugi.pantsutags.TabRoute

@Serializable
@SerialName("settings")
class SettingsDestination() : TabRoute() {
    override val displayName: String = DISPLAY_NAME
    override val icon: ImageVector get() = ICON

    companion object {
        const val DISPLAY_NAME: String = "Settings"
        val ICON: ImageVector = Icons.Default.Settings
    }
}

fun NavGraphBuilder.settingsRoutes() {
    composable<SettingsDestination> { SettingsScreen() }
}