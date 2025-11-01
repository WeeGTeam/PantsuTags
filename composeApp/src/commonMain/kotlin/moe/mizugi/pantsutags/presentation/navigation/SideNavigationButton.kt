package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.mizugi.pantsutags.AppRoute
import moe.mizugi.pantsutags.services.navigation.NavigationService
import org.koin.compose.koinInject

@Composable
fun SideNavigationButton(
    appRoute: AppRoute,
    height: Dp = 50.dp,
    navigationService: NavigationService = koinInject(),
) {
    Button(
        onClick = { navigationService.navigateTo(appRoute) },
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
                appRoute.icon,
                contentDescription = null,
                modifier = Modifier.fillMaxHeight().padding(end = 0.dp)
            )
            Text(
                appRoute.name,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp).weight(1f),
            )
        }
    }
}