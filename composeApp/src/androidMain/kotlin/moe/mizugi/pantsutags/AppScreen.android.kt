package moe.mizugi.pantsutags

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.mizugi.pantsutags.presentation.navigation.BottomNavigation

@Composable
actual fun AppScreen(content: @Composable (() -> Unit)) {
    Column(
        modifier = Modifier.safeContentPadding()
    ) {
        Box(modifier = Modifier.weight(1f)) {
            content()
        }
        BottomNavigation()
    }
}