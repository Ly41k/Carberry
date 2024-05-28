package pro.carberry.multiplatform.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.features.auth.login.compose.LoginScreen
import pro.carberry.multiplatform.features.splash.compose.SplashScreen


@Composable
fun RootAppGraph(navController: NavHostController = rememberNavController()) {

    CompositionLocalProvider(
        LocalRootNavHostController provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = RootAppScreens.Splash.name
        ) {
            composable(route = RootAppScreens.Splash.name) { SplashScreen() }
            composable(route = RootAppScreens.Login.name) { LoginScreen() }
            composable(route = RootAppScreens.Main.name) { MainAppGraph() }
        }
    }
}
