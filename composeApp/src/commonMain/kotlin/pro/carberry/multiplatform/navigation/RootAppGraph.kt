package pro.carberry.multiplatform.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.features.auth.login.compose.LoginScreen
import pro.carberry.multiplatform.features.splash.compose.SplashScreen
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun RootAppGraph(navController: NavHostController = rememberNavController()) {

    CompositionLocalProvider(
        LocalRootNavHostController provides navController
    ) {
        NavHost(
            modifier = Modifier.fillMaxSize().background(AppTheme.colors.primaryBackground),
            navController = navController,
            startDestination = RootAppScreens.Splash.name
        ) {
            composable(route = RootAppScreens.Splash.name) { SplashScreen() }
            composable(route = RootAppScreens.Login.name) { LoginScreen() }
            composable(route = RootAppScreens.Main.name) { MainAppGraph() }
        }
    }
}
