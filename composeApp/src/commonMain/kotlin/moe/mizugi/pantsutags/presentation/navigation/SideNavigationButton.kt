package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.composeunstyled.ProvideContentColor
import com.composeunstyled.Text
import com.composeunstyled.UnstyledButton
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer
import moe.mizugi.pantsutags.TabRoute
import moe.mizugi.pantsutags.presentation.components.KaniIcon
import moe.mizugi.pantsutags.presentation.theme.LocalKaniColors
import moe.mizugi.pantsutags.presentation.theme.LocalKaniTypography
import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@OptIn(InternalSerializationApi::class)
@Composable
fun SideNavigationButton(
    tabRoute: TabRoute,
    isExpanded: Boolean = true,
    height: Dp = 50.dp,
    navigationService: NavigationService = koinInject(),
) {
    val navController by navigationService.getNavController()
    val isCurrentRoute = navController?.currentBackStack?.collectAsState()?.value
        ?.any { it.destination.route?.startsWith(tabRoute::class.serializer().descriptor.serialName) ?: false }
        ?: false
    UnstyledButton(
        onClick = { navigationService.navigateTo(tabRoute) },
        indication = LocalIndication.current,
        contentPadding = PaddingValues(all = 10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(if (isCurrentRoute) LocalKaniColors.current.primary else LocalKaniColors.current.secondary)
            .border(1.dp, Color.Black),
    ) {
        ProvideContentColor(if (isCurrentRoute) LocalKaniColors.current.onPrimary else LocalKaniColors.current.onSecondary) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                KaniIcon(
                    tabRoute.icon,
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight().padding(end = 0.dp)
                )
                AnimatedContent(targetState = isExpanded) { targetState ->
                    if (targetState) {
                        Text(
                            stringResource(tabRoute.displayName),
                            style = LocalKaniTypography.current.title,
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp).weight(1f),
                        )
                    }
                }
            }
        }
    }
}
