package moe.mizugi.pantsutags

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.awtEventOrNull
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import java.awt.Toolkit
import java.awt.event.MouseEvent

private val BACK_BUTTON = when (Toolkit.getDefaultToolkit().javaClass.name) {
    "sun.awt.X11.XToolkit" -> 6
    else -> 4
}

@OptIn(ExperimentalComposeUiApi::class)
actual fun Modifier.onMouseBackEvent(function: () -> Unit): Modifier = this
    .onPointerEvent(PointerEventType.Press) { if (it.isBackButtonPress()) function() }
    // Compose only tracks buttons 1..5, so on X11 the back button changes no pointer state and
    // the press gets filtered as a duplicate and re-dispatched as Unknown instead of Press.
    .onPointerEvent(PointerEventType.Unknown) { if (it.isBackButtonPress()) function() }

private fun PointerEvent.isBackButtonPress(): Boolean {
    val awtEvent = awtEventOrNull ?: return false
    return awtEvent.id == MouseEvent.MOUSE_PRESSED && awtEvent.button == BACK_BUTTON
}
