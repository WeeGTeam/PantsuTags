package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.import.ImportDestination

@Composable
fun SideNavigation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = Color(255, 100, 120, 255))
            .fillMaxHeight()
            .padding(end = 0.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalAlignment = Alignment.End
    ) {
        SideNavigationButton(GalleryDestination)
        SideNavigationButton(ImportDestination)
    }
}
