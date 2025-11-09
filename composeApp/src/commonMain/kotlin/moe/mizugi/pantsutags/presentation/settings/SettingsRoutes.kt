package moe.mizugi.pantsutags.presentation.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.mizugi.pantsutags.TabRoute
import org.jetbrains.compose.resources.StringResource
import pantsutags.composeapp.generated.resources.Res
import pantsutags.composeapp.generated.resources.tab_route_name_settings

@Serializable
@SerialName("settings")
class SettingsDestination() : TabRoute() {
    override val displayName: StringResource get() = DISPLAY_NAME
    override val icon: ImageVector get() = ICON

    companion object {
        val DISPLAY_NAME: StringResource = Res.string.tab_route_name_settings
        val ICON: ImageVector = Icons.Default.Settings
    }
}

fun NavGraphBuilder.settingsRoutes() {
    composable<SettingsDestination> { SettingsScreen() }
}