package moe.mizugi.pantsutags

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import coil3.compose.setSingletonImageLoaderFactory
import moe.mizugi.pantsutags.imageloader.imageLoaderFactory
import moe.mizugi.pantsutags.presentation.gallery.GalleryDestination
import moe.mizugi.pantsutags.presentation.gallery.galleryRoutes
import moe.mizugi.pantsutags.presentation.image.imageRoutes
import moe.mizugi.pantsutags.presentation.import.importRoutes
import moe.mizugi.pantsutags.presentation.settings.settingsRoutes
import moe.mizugi.pantsutags.presentation.theme.DarkColorScheme
import moe.mizugi.pantsutags.presentation.theme.LightColorScheme
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
        MaterialTheme(
            colorScheme = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme,
        ) {
            AppScreen {
                NavHost(
                    modifier = Modifier.fillMaxSize().padding(5.dp),
                    navController = navController,
                    startDestination = GalleryDestination(),
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                ) {
                    galleryRoutes()
                    imageRoutes()
                    importRoutes()
                    settingsRoutes()
                }
            }
        }
        LaunchedEffect(navController) {
            navigationService.setNavController(navController)
            onNavHostReady(navController)
        }
    }
}