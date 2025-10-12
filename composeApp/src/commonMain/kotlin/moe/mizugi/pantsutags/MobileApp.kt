package moe.mizugi.pantsutags

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.gallery.galleryRoutes
import moe.mizugi.pantsutags.presentation.import.importRoutes
import moe.mizugi.pantsutags.presentation.navigation.BottomNavigation
import org.koin.compose.KoinMultiplatformApplication
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.koinConfiguration

@OptIn(KoinExperimentalAPI::class)
@Composable
fun MobileApp() {
    KoinMultiplatformApplication (config = koinConfiguration {
        modules(appModule)
    }){
        val navController = rememberNavController()

        MaterialTheme {
            Column(modifier = Modifier.safeContentPadding()) {
                NavHost(navController = navController, startDestination = GalleryDestination) {
                    galleryRoutes()
                    importRoutes()
                }
                BottomNavigation(navigateTo = { navController.navigate(it) })
            }
        }
    }
}