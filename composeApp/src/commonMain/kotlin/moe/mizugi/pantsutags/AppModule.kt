package moe.mizugi.pantsutags

import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.koin.dsl.module

val appModule = module {
    single { NavigationService() }
}