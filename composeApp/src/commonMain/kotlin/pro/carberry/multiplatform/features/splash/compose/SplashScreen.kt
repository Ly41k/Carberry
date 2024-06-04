package pro.carberry.multiplatform.features.splash.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.features.splash.presentation.SplashViewModel
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction.OpenLoginScreen
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction.OpenMainScreen
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction.OpenOnboardingScreen
import pro.carberry.multiplatform.navigation.AuthAppScreens
import pro.carberry.multiplatform.navigation.RootAppScreens

@Composable
fun SplashScreen(viewModel: SplashViewModel = viewModel { SplashViewModel() }) {
    val navController = LocalRootNavHostController.current
    val viewAction by viewModel.viewActions().observeAsState()

    SplashView()

    when (viewAction) {
        OpenLoginScreen -> navController.navigateToLogin()
        OpenMainScreen -> navController.navigateToMain()
        OpenOnboardingScreen -> navController.navigateToOnboarding()
        null -> {
            /* Do nothing*/
        }
    }
}

private fun NavHostController.navigateToLogin() {
    popBackStack()
    navigate(AuthAppScreens.Login.name)
}

private fun NavHostController.navigateToMain() {
    popBackStack()
    navigate(RootAppScreens.Main.name)
}

private fun NavHostController.navigateToOnboarding() {
    popBackStack()
    navigate(RootAppScreens.Onboarding.name)
}
