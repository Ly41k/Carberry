package pro.carberry.multiplatform.core.naviagtion

import androidx.navigation.NavHostController
import pro.carberry.multiplatform.navigation.RootAppScreens

fun NavHostController.navigateToLogin() {
    popBackStack()
    navigate(RootAppScreens.Login.name)
}

fun NavHostController.navigateToMain() {
    navigate(RootAppScreens.Main.name)
}

fun NavHostController.navigateToOnboarding() {
    navigate(RootAppScreens.Onboarding.name)
}
