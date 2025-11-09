package moe.mizugi.pantsutags.services.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import androidx.navigation.navOptions
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer
import moe.mizugi.pantsutags.AppRoute
import moe.mizugi.pantsutags.TabRoute

private val logger = KotlinLogging.logger {}

class NavigationService {
    private var navController: MutableState<NavController?> = mutableStateOf(null)

    fun navigateBack() {
        withNavController {
            if (currentBackStack.value.size > 2) {
                popBackStack()
            }
        }
    }

    @OptIn(InternalSerializationApi::class)
    fun navigateTo(targetRoute: AppRoute) {
        val targetRouteName = targetRoute::class.serializer().descriptor.serialName
        withNavController {
            val currentRoute = currentDestination?.route ?: return@withNavController
            logger.info { "Navigating from $currentRoute to $targetRouteName" }
            val tabRouteName = currentBackStack.value[1].destination.route ?: return@withNavController

            if (targetRoute is TabRoute) {
                if (targetRouteName == tabRouteName) {
                    popBackStack(tabRouteName, false)
                } else {
                    navigate(
                        targetRoute,
                        navOptions {
                            popUpTo(tabRouteName) {
                                saveState = true
                                inclusive = true
                            }
                            restoreState = true
                        }
                    )
                }
            } else {
                navigate(targetRoute)
            }
        }
    }

    fun setNavController(navController: NavController) {
        this.navController.value = navController
    }

    fun getNavController(): State<NavController?> {
        return navController
    }

    private fun withNavController(block: NavController.() -> Unit) {
        navController.value?.run {
            logger.info { "Pre navigate stack ${currentBackStack.value.map { it.destination.route }}" }
            block()
            logger.info { "Post navigate stack ${currentBackStack.value.map { it.destination.route }}" }
        } ?: logger.error { "NavController is not set" }
    }
}