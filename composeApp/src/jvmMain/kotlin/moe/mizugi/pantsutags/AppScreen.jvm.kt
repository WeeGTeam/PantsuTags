package moe.mizugi.pantsutags

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import moe.mizugi.pantsutags.presentation.navigation.SideNavigation

@Composable
actual fun AppScreen(content: @Composable (() -> Unit)) {
    Row(modifier = Modifier.safeContentPadding()) {
        SideNavigation()
        Box(modifier = Modifier.padding(5.dp)) {
            content()
        }
    }
}