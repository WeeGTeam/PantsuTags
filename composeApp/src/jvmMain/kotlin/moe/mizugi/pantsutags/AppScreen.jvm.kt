package moe.mizugi.pantsutags

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import moe.mizugi.pantsutags.presentation.navigation.SideNavigation

@Composable
actual fun AppScreen(navController: NavHostController, content: @Composable (() -> Unit)) {
    Row(modifier = Modifier.safeContentPadding()) {
        SideNavigation(navigateTo = { navController.navigate(it) }, Modifier.width(200.dp))
        content()
    }
}