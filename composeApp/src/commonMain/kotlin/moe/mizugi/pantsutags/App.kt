package moe.mizugi.pantsutags

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import coil3.compose.setSingletonImageLoaderFactory
import moe.mizugi.pantsutags.imageloader.imageLoaderFactory
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.gallery.galleryRoutes
import moe.mizugi.pantsutags.presentation.import.importRoutes
import moe.mizugi.pantsutags.services.navigation.NavigationService
import moe.mizugi.pantsutags.services.servicesModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinMultiplatformApplication
import org.koin.compose.koinInject
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.koinConfiguration

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App(onNavHostReady: suspend (NavController) -> Unit = {}) {
    setSingletonImageLoaderFactory(::imageLoaderFactory)
    KoinMultiplatformApplication(config = koinConfiguration {
        modules(servicesModule)
    }) {
        val navController = rememberNavController()
        val navigationService = koinInject<NavigationService>()
        MaterialTheme {
            AppScreen {
                NavHost(
                    navController = navController,
                    startDestination = GalleryDestination,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                ) {
                    galleryRoutes()
                    importRoutes()
                }
            }
        }
        LaunchedEffect(navController) {
            navigationService.setNavController(navController)
            onNavHostReady(navController)
        }
    }
}