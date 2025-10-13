package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.import.ImportDestination
import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.koin.compose.koinInject

@Composable
fun SideNavigation(navigationService: NavigationService = koinInject(), modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(Color.Red)
            .fillMaxHeight()
    ) {
        Button(
            onClick = { navigationService.navigateTo(GalleryDestination) },
        ) {
            Text("Gallery")
        }
        Button(
            onClick = { navigationService.navigateTo(ImportDestination) },
        ) {
            Text("Import")
        }
    }
}
