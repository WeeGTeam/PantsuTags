package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Menu
import moe.mizugi.pantsutags.presentation.components.KaniIcon
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.import.ImportDestination
import moe.mizugi.pantsutags.presentation.settings.SettingsDestination
import moe.mizugi.pantsutags.presentation.theme.LocalKaniColors
import moe.mizugi.pantsutags.presentation.theme.LocalNavigationKaniColors
import moe.mizugi.pantsutags.presentation.theme.ProvideKaniColors

@Composable
fun SideNavigation(minWidth: Dp = 50.dp, maxWith: Dp = 220.dp) {
    var isExpanded by remember { mutableStateOf(true) }
    val targetWidth = if (isExpanded) maxWith else minWidth
    val animatedWidth by animateDpAsState(
        targetWidth,
        animationSpec = spring(dampingRatio = 1f, stiffness = Spring.StiffnessMedium)
    )

    ProvideKaniColors(LocalNavigationKaniColors.current) {
        Column(
            modifier = Modifier
                .width(animatedWidth)
                .fillMaxHeight()
                .background(LocalKaniColors.current.background)
                .padding(end = 0.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            KaniIcon(
                Lucide.Menu,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(5.dp)
                    .clickable { isExpanded = !isExpanded },
                tint = LocalKaniColors.current.primary
            )
            SideNavigationButton(GalleryDestination(), isExpanded = isExpanded)
            SideNavigationButton(ImportDestination(), isExpanded = isExpanded)
            SideNavigationButton(SettingsDestination(), isExpanded = isExpanded)
        }
    }
}
