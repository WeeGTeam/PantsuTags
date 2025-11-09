package moe.mizugi.pantsutags

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.mizugi.pantsutags.presentation.navigation.BottomNavigation

@Composable
actual fun AppScreen(content: @Composable (() -> Unit)) {
    Surface(
        color = MaterialTheme.colorScheme.background,
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