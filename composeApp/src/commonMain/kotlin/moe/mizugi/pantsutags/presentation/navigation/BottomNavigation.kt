package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import moe.mizugi.pantsutags.AppRoute
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.import.ImportDestination

@Composable
fun BottomNavigation(navigateTo: (AppRoute) -> Unit) {
    Row {
        Button(
            onClick = { navigateTo(GalleryDestination) },
        ) {
            Text("Gallery")
        }
        Button(
            onClick = { navigateTo(ImportDestination) },
        ) {
            Text("Import")
        }
    }
}
