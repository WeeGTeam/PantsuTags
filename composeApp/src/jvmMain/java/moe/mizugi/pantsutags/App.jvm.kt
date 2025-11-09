package moe.mizugi.pantsutags

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.isBack
import androidx.compose.ui.input.pointer.onPointerEvent

@OptIn(ExperimentalComposeUiApi::class)
actual fun Modifier.onMouseBackEvent(function: () -> Unit): Modifier =
    this.onPointerEvent(PointerEventType.Press) { event ->
        println(event.button)
        if (event.button?.index == 5) {
            println(event.button.isBack)
            function()
        }
    }