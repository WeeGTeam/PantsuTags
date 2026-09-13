package moe.mizugi.pantsutags.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class KaniColors(
    val background: Color,
    val onBackground: Color,
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val surface: Color,
    val onSurface: Color,
)

object LightColorPalette {
    val black = Color(0, 0, 0)
    val grey1 = Color(23, 25, 28)
    val grey8 = Color(220, 210, 220)
    val white = Color(255, 255, 255)
    val pink5 = Color(255, 0, 255)
    val pink8 = Color(255, 180, 255)
    val turquoise = Color(150, 255, 255)
}

object DarkColorPalette {
    val black = Color(0, 0, 0)
    val grey1 = Color(23, 25, 28)
    val grey2 = Color(33, 35, 38)
    val grey3 = Color(53, 55, 58)
    val white = Color(255, 255, 255)
    val pink = Color(255, 185, 255)
    val turquoise1 = Color(0, 128, 128)
    val turquoise2 = Color(75, 128, 128)
}

val LightKaniColors = KaniColors(
    background = LightColorPalette.white,
    onBackground = LightColorPalette.black,
    primary = LightColorPalette.pink5,
    onPrimary = LightColorPalette.white,
    secondary = LightColorPalette.turquoise,
    onSecondary = LightColorPalette.grey1,
    surface = LightColorPalette.white,
    onSurface = LightColorPalette.grey1,
)

val LightNavigationKaniColors = LightKaniColors.copy(
    background = LightColorPalette.grey8,
    primary = LightColorPalette.pink5,
    onPrimary = LightColorPalette.black,
    secondary = LightColorPalette.pink8,
    onSecondary = LightColorPalette.black,
)

val DarkKaniColors = KaniColors(
    background = DarkColorPalette.grey1,
    onBackground = DarkColorPalette.white,
    primary = DarkColorPalette.turquoise1,
    onPrimary = DarkColorPalette.white,
    secondary = DarkColorPalette.turquoise2,
    onSecondary = DarkColorPalette.white,
    surface = DarkColorPalette.grey1,
    onSurface = DarkColorPalette.white,
)

val DarkNavigationKaniColors = DarkKaniColors.copy(
    background = DarkColorPalette.grey2,
    primary = DarkColorPalette.pink,
    onPrimary = DarkColorPalette.black,
    secondary = DarkColorPalette.grey3,
    onSecondary = DarkColorPalette.pink,
)
