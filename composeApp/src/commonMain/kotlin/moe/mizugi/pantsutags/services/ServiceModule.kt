package moe.mizugi.pantsutags.services

import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.koin.dsl.module

val servicesModule = module {
    single { NavigationService() }
}