package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.import.ImportDestination
import moe.mizugi.pantsutags.presentation.settings.SettingsDestination
import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun BottomNavigation(navigationService: NavigationService = koinInject()) {
    Row {
        Button(
            onClick = { navigationService.navigateTo(GalleryDestination()) },
        ) {
            Text(stringResource(GalleryDestination.DISPLAY_NAME))
        }
        Button(
            onClick = { navigationService.navigateTo(ImportDestination()) },
        ) {
            Text(stringResource(ImportDestination.DISPLAY_NAME))
        }
        Button(
            onClick = { navigationService.navigateTo(SettingsDestination()) },
        ) {
            Text(stringResource(SettingsDestination.DISPLAY_NAME))
        }
    }
}
