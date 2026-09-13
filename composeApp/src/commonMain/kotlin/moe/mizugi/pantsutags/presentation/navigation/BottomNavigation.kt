package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.composeunstyled.Text
import moe.mizugi.pantsutags.presentation.components.KaniButton
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.import.ImportDestination
import moe.mizugi.pantsutags.presentation.settings.SettingsDestination
import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun BottomNavigation(navigationService: NavigationService = koinInject()) {
    Row {
        KaniButton(
            onClick = { navigationService.navigateTo(GalleryDestination()) },
        ) {
            Text(stringResource(GalleryDestination.DISPLAY_NAME))
        }
        KaniButton(
            onClick = { navigationService.navigateTo(ImportDestination()) },
        ) {
            Text(stringResource(ImportDestination.DISPLAY_NAME))
        }
        KaniButton(
            onClick = { navigationService.navigateTo(SettingsDestination()) },
        ) {
            Text(stringResource(SettingsDestination.DISPLAY_NAME))
        }
    }
}
