package moe.mizugi.pantsutags.presentation.components

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.composeunstyled.ProvideContentColor
import com.composeunstyled.ProvideTextStyle
import com.composeunstyled.UnstyledButton
import moe.mizugi.pantsutags.presentation.theme.LocalKaniColors
import moe.mizugi.pantsutags.presentation.theme.LocalKaniTypography

@Composable
fun KaniButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) {
    UnstyledButton(
        onClick = onClick,
        enabled = enabled,
        indication = LocalIndication.current,
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
        modifier = modifier
            .heightIn(min = 40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(LocalKaniColors.current.primary),
    ) {
        ProvideContentColor(LocalKaniColors.current.onPrimary) {
            ProvideTextStyle(LocalKaniTypography.current.label) {
                Row(verticalAlignment = Alignment.CenterVertically, content = content)
            }
        }
    }
}
