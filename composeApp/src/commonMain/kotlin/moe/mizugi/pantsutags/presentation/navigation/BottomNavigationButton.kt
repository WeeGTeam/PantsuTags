package moe.mizugi.pantsutags.presentation.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.mizugi.pantsutags.TabRoute
import moe.mizugi.pantsutags.presentation.theme.LocalBottomNavigationColor
import moe.mizugi.pantsutags.services.navigation.NavigationService
import moe.mizugi.pantsutags.services.navigation.containsTabRoute
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.dsl.module

@Composable
fun RowScope.BottomNavigationButton(tabRoute: TabRoute, navigationService: NavigationService = koinInject()) {
    val navController by navigationService.getNavController()
    val selected =
        navController?.currentBackStack?.collectAsState()?.value?.containsTabRoute(tabRoute::class) ?: false
    Button(
        onClick = { navigationService.navigateTo(tabRoute) },
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = if (selected) LocalBottomNavigationColor.current.buttonSelected else LocalBottomNavigationColor.current.button,
            contentColor = if (selected) LocalBottomNavigationColor.current.buttonContentSelected else LocalBottomNavigationColor.current.buttonContent
        ),
        modifier = Modifier.weight(1f),
        shape = RoundedCornerShape(20),
        contentPadding = PaddingValues(all = 0.dp),
    ) {
        Column(
            modifier = Modifier.padding(vertical = 5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                tabRoute.icon,
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            Text(
                stringResource(tabRoute.displayName),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
            )

        }

    }
}

@Composable
@Preview
fun BottomNavigationButtonPreview() {
    org.koin.compose.KoinApplication(
        application = {
            modules(module {
                single { NavigationService() }
            })
        }
    ) {

        BottomNavigation()
    }
}