package moe.mizugi.pantsutags.services

import moe.mizugi.pantsutags.services.navigation.NavigationService
import moe.mizugi.pantsutags.services.network.networkModule
import org.koin.dsl.module

val servicesModule = module {
    includes(networkModule)

    single { NavigationService() }
}
