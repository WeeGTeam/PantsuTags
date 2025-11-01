package moe.mizugi.pantsutags

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.mizugi.pantsutags.presentation.navigation.SideNavigation

@Composable
actual fun AppScreen(content: @Composable (() -> Unit)) {
    Row(modifier = Modifier.safeContentPadding()) {
        SideNavigation()
        content()
    }
}