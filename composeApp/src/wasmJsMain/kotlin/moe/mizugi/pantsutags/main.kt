package moe.mizugi.pantsutags

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToBrowserNavigation
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalBrowserHistoryApi
fun main() {
    ComposeViewport(document.body!!) {
        DesktopApp(onNavHostReady = { it.bindToBrowserNavigation() })
    }
}