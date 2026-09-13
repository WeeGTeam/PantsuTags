package moe.mizugi.pantsutags.presentation.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.composeunstyled.LocalContentColor
import com.composeunstyled.LocalTextStyle
import com.composeunstyled.theme.rememberColoredIndication

val LocalKaniColors = staticCompositionLocalOf<KaniColors> { error("No KaniTheme provided") }
val LocalNavigationKaniColors = staticCompositionLocalOf<KaniColors> { error("No KaniTheme provided") }
val LocalKaniTypography = staticCompositionLocalOf<KaniTypography> { error("No KaniTheme provided") }

@Composable
fun KaniTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: KaniColors = if (darkTheme) DarkKaniColors else LightKaniColors,
    navigationColors: KaniColors = if (darkTheme) DarkNavigationKaniColors else LightNavigationKaniColors,
    typography: KaniTypography = DefaultKaniTypography,
    content: @Composable () -> Unit,
) {
    val indication = rememberColoredIndication(
        hoveredColor = colors.onBackground.copy(alpha = 0.08f),
        pressedColor = colors.onBackground.copy(alpha = 0.12f),
        focusedColor = colors.onBackground.copy(alpha = 0.12f),
    )
    CompositionLocalProvider(
        LocalKaniColors provides colors,
        LocalNavigationKaniColors provides navigationColors,
        LocalKaniTypography provides typography,
        LocalTextStyle provides typography.body,
        LocalContentColor provides colors.onBackground,
        LocalIndication provides indication,
        content = content,
    )
}

@Composable
fun ProvideKaniColors(colors: KaniColors, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalKaniColors provides colors,
        LocalContentColor provides colors.onBackground,
        content = content,
    )
}
