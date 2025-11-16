package moe.mizugi.pantsutags.presentation.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LightColorScheme = lightColorScheme(
    primary = Color(255, 0, 255),
    secondary = Color(150, 255, 255),
    surface = Color(255, 100, 120),
)

val DarkColorScheme = darkColorScheme(
    primary = Color(0, 128, 128),
    onPrimary = Color(255, 255, 255),
    secondary = Color(75, 128, 128),
    background = Color(23, 25, 28, 255),
    onBackground = Color(255, 255, 255),
    surface = Color(30, 10, 40),
    onSurface = Color(255, 255, 255),
)

val LocalSideNavigationColor = staticCompositionLocalOf { lightSideNavigationColors() }

data class SideNavigationColors(
    val background: Color,
    val button: Color,
    val buttonSelected: Color,
    val buttonContent: Color,
    val buttonContentSelected: Color,
)

fun lightSideNavigationColors(): SideNavigationColors =
    SideNavigationColors(
        background = Color(43, 45, 48, 255),
        button = Color(43, 45, 48, 255),
        buttonSelected = Color(255, 165, 255, 255),
        buttonContent = Color(255, 0, 255),
        buttonContentSelected = Color(255, 0, 255),
    )

fun darkSideNavigationColors(): SideNavigationColors =
    SideNavigationColors(
        background = Color(33, 35, 38, 255),
        button = Color(53, 55, 58, 255),
        buttonSelected = Color(255, 185, 255, 255),
        buttonContent = Color(255, 185, 255, 255),
        buttonContentSelected = Color(0, 0, 0),
    )

val LocalBottomNavigationColor = staticCompositionLocalOf { lightBottomNavigationColors() }

data class BottomNavigationColors(
    val background: Color,
    val button: Color,
    val buttonSelected: Color,
    val buttonContent: Color,
    val buttonContentSelected: Color,
)

fun lightBottomNavigationColors(): BottomNavigationColors =
    BottomNavigationColors(
        background = Color(255, 230, 255),
        button = Color.Transparent,
        buttonSelected = Color(255, 170, 255),
        buttonContent = Color(200, 0, 200),
        buttonContentSelected = Color(150, 0, 150),
    )

fun darkBottomNavigationColors(): BottomNavigationColors =
    BottomNavigationColors(
        background = Color(33, 35, 38),
        button = Color.Transparent,
        buttonSelected = Color(255, 185, 255),
        buttonContent = Color(255, 185, 255),
        buttonContentSelected = Color(0, 0, 0),
    )