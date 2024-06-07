package pro.carberry.multiplatform.features.splash.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateWithPopBackStack
import pro.carberry.multiplatform.features.splash.presentation.SplashViewModel
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction.OpenLoginScreen
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction.OpenMainScreen
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction.OpenOnboardingScreen
import pro.carberry.multiplatform.navigation.AuthAppScreens.Login
import pro.carberry.multiplatform.navigation.RootAppScreens.Main
import pro.carberry.multiplatform.navigation.RootAppScreens.Onboarding

@Composable
fun SplashScreen(viewModel: SplashViewModel = viewModel { SplashViewModel() }) {
    val navController = LocalRootNavHostController.current
    val viewAction by viewModel.viewActions().observeAsState()

    SplashView()

    when (viewAction) {
        OpenLoginScreen -> navController.navigateWithPopBackStack(Login.name)
        OpenMainScreen -> navController.navigateWithPopBackStack(Main.name)
        OpenOnboardingScreen -> navController.navigateWithPopBackStack(Onboarding.name)
        null -> {
            /* Do nothing*/
        }
    }
}
