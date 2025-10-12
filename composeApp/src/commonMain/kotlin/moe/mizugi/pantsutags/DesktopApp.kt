package moe.mizugi.pantsutags

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.gallery.galleryRoutes
import moe.mizugi.pantsutags.presentation.import.importRoutes
import moe.mizugi.pantsutags.presentation.navigation.SideNavigation
import org.koin.compose.KoinMultiplatformApplication
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.koinConfiguration

@OptIn(KoinExperimentalAPI::class)
@Composable
fun DesktopApp(onNavHostReady: suspend (NavController) -> Unit = {}) {
    KoinMultiplatformApplication (config = koinConfiguration {
        modules(appModule)
    }) {
        val navController = rememberNavController()
        MaterialTheme {
            Row(modifier = Modifier.safeContentPadding()) {
                SideNavigation(navigateTo = { navController.navigate(it) }, Modifier.width(200.dp))
                NavHost(
                    navController = navController,
                    startDestination = GalleryDestination,
                ) {
                    galleryRoutes()
                    importRoutes()
                }
            }
        }
        LaunchedEffect(navController) {
            onNavHostReady(navController)
        }
    }
}