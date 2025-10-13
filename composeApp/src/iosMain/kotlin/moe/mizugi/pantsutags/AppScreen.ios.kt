package moe.mizugi.pantsutags

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import moe.mizugi.pantsutags.presentation.navigation.BottomNavigation

@Composable
actual fun AppScreen(navController: NavHostController, content: @Composable (() -> Unit)) {
    Column(
        modifier = Modifier.safeContentPadding()
    ) {
        Box(modifier = Modifier.weight(1f)) {
            content()
        }
        BottomNavigation(navigateTo = { navController.navigate(it) })
    }
}