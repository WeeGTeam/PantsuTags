package moe.mizugi.pantsutags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.mizugi.pantsutags.presentation.navigation.SideNavigation
import moe.mizugi.pantsutags.presentation.theme.LocalKaniColors

@Composable
actual fun AppScreen(content: @Composable (() -> Unit)) {
    Row(modifier = Modifier.safeContentPadding()) {
        SideNavigation()
        Box(modifier = Modifier.background(LocalKaniColors.current.background)) {
            content()
        }
    }
}
