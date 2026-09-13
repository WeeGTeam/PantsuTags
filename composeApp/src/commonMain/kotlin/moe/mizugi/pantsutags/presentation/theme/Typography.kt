package moe.mizugi.pantsutags.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class KaniTypography(
    val body: TextStyle,
    val label: TextStyle,
    val title: TextStyle,
)

val DefaultKaniTypography = KaniTypography(
    body = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    label = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        fontWeight = FontWeight.Medium,
    ),
    title = TextStyle(
        fontSize = 20.sp,
        lineHeight = 28.sp,
    ),
)
