package moe.mizugi.pantsutags.services.navigation

import androidx.navigation.NavController
import moe.mizugi.pantsutags.AppRoute

class NavigationService {
    private var navController: NavController? = null

    fun navigateTo(route: AppRoute) {
        this.navController?.navigate(route)
    }

    fun setNavController(navController: NavController) {
        this.navController = navController
    }
}