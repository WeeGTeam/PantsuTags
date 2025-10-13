package moe.mizugi.pantsutags.services.navigation

import androidx.navigation.NavController
import io.github.oshai.kotlinlogging.KotlinLogging
import moe.mizugi.pantsutags.AppRoute

private val logger = KotlinLogging.logger {}

class NavigationService {
    private var navController: NavController? = null

    fun navigateTo(route: AppRoute) {
        this.navController?.navigate(route) ?: logger.error { "NavController is not set" }
    }

    fun setNavController(navController: NavController) {
        this.navController = navController
    }
}