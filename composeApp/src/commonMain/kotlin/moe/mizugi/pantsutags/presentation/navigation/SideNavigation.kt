package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.import.ImportDestination
import moe.mizugi.pantsutags.presentation.settings.SettingsDestination
import moe.mizugi.pantsutags.presentation.theme.LocalSideNavigationColor
import moe.mizugi.pantsutags.presentation.theme.darkNavigationColors
import moe.mizugi.pantsutags.presentation.theme.lightNavigationColors

@Composable
fun SideNavigation(minWidth: Dp = 50.dp, maxWith: Dp = 220.dp) {
    var isExpanded by remember { mutableStateOf(true) }
    val targetWidth = if (isExpanded) maxWith else minWidth
    val animatedWidth by animateDpAsState(
        targetWidth,
        animationSpec = spring(dampingRatio = 1f, stiffness = Spring.StiffnessMedium)
    )

    CompositionLocalProvider(
        LocalSideNavigationColor provides if (isSystemInDarkTheme()) darkNavigationColors() else lightNavigationColors()
    ) {
        Column(
            modifier = Modifier
                .width(animatedWidth)
                .fillMaxHeight()
                .background(LocalSideNavigationColor.current.background)
                .padding(end = 0.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(5.dp)
                    .clickable { isExpanded = !isExpanded },
                tint = LocalSideNavigationColor.current.buttonContent
            )
            SideNavigationButton(GalleryDestination(), isExpanded = isExpanded)
            SideNavigationButton(ImportDestination(), isExpanded = isExpanded)
            SideNavigationButton(SettingsDestination(), isExpanded = isExpanded)
        }
    }
}
