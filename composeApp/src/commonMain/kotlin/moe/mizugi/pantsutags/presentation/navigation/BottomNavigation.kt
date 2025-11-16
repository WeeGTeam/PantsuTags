package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.import.ImportDestination
import moe.mizugi.pantsutags.presentation.settings.SettingsDestination
import moe.mizugi.pantsutags.presentation.theme.LocalBottomNavigationColor
import moe.mizugi.pantsutags.presentation.theme.darkBottomNavigationColors
import moe.mizugi.pantsutags.presentation.theme.lightBottomNavigationColors

@Composable
fun BottomNavigation() {
    CompositionLocalProvider(
        LocalBottomNavigationColor provides if (isSystemInDarkTheme()) darkBottomNavigationColors() else lightBottomNavigationColors()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(LocalBottomNavigationColor.current.background)
                .safeContentPadding(),
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationButton(GalleryDestination())
            BottomNavigationButton(ImportDestination())
            BottomNavigationButton(SettingsDestination())
        }
    }
}
