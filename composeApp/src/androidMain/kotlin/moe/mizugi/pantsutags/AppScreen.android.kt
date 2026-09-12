package moe.mizugi.pantsutags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.mizugi.pantsutags.presentation.navigation.BottomNavigation
import moe.mizugi.pantsutags.presentation.theme.LocalKaniColors

@Composable
actual fun AppScreen(content: @Composable (() -> Unit)) {
    Box(
        modifier = Modifier.background(LocalKaniColors.current.background),
    ) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            Box(modifier = Modifier.weight(1f)) {
                content()
            }
            BottomNavigation()
        }
    }
}
