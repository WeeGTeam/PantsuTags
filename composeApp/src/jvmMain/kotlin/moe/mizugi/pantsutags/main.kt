package moe.mizugi.pantsutags

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PantsuTags",
    ) {
        DesktopApp(onNavHostReady = {})
    }
}