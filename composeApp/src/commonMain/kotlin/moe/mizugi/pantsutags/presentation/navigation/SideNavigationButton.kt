package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer
import moe.mizugi.pantsutags.TabRoute
import moe.mizugi.pantsutags.presentation.theme.LocalSideNavigationColor
import moe.mizugi.pantsutags.services.navigation.NavigationService
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
    Button(
        onClick = { navigationService.navigateTo(tabRoute) },
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = if (isCurrentRoute) LocalSideNavigationColor.current.buttonSelected else LocalSideNavigationColor.current.button,
            contentColor = if (isCurrentRoute) LocalSideNavigationColor.current.buttonContentSelected else LocalSideNavigationColor.current.buttonContent
        ),
        modifier = Modifier.fillMaxWidth().height(height),
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(1.dp, Color.Black),
        contentPadding = PaddingValues(all = 10.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                tabRoute.icon,
                contentDescription = null,
                modifier = Modifier.fillMaxHeight().padding(end = 0.dp)
            )
            AnimatedContent(targetState = isExpanded) { targetState ->
                if (targetState) {
                    Text(
                        tabRoute.displayName,
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth().padding(start = 10.dp).weight(1f),
                    )
                }
            }
        }
    }
}