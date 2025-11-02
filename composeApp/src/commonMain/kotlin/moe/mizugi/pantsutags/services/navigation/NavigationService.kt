package moe.mizugi.pantsutags.services.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import io.github.oshai.kotlinlogging.KotlinLogging
import moe.mizugi.pantsutags.AppRoute

private val logger = KotlinLogging.logger {}

class NavigationService {
    private var navController: MutableState<NavController?> = mutableStateOf(null)

    fun navigateTo(route: AppRoute) {
        this.navController.value?.navigate(route) ?: logger.error { "NavController is not set" }
    }

    fun setNavController(navController: NavController) {
        this.navController.value = navController
    }

    fun getNavController(): State<NavController?> {
        return navController
    }
}