package moe.mizugi.pantsutags

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
expect fun AppScreen(navController: NavHostController, content: @Composable () -> Unit)