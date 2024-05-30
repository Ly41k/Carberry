package pro.carberry.multiplatform.core.naviagtion

import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import pro.carberry.multiplatform.navigation.RootAppScreens

fun NavHostController.navigateToLogin() {
    popBackStack()
    navigateSafety(RootAppScreens.Login.name)
}

fun NavHostController.navigateToMain() {
    navigateSafety(RootAppScreens.Main.name)
}

fun NavHostController.navigateToOnboarding() {
    navigateSafety(RootAppScreens.Onboarding.name)
}

fun NavHostController.navigateToForgotPassword() {
    navigateSafety(RootAppScreens.ForgotPassword.name)
}

fun NavHostController.navigateToRegistration() {
    navigateSafety(RootAppScreens.Register.name)
}

fun NavHostController.navigateToRefundPolicy() {
    navigateSafety(RootAppScreens.RefundPolicy.name)
}

fun NavHostController.navigateToTermsOfService() {
    navigateSafety(RootAppScreens.TermsOfService.name)
}

private fun NavHostController.navigateSafety(route: String, navOptions: NavOptions? = null) {
    try {
        navigate(route, navOptions)
    } catch (nie: NotImplementedError) {
        println("NavHostController Exception - ${nie.message}")
    } catch (e: Exception) {
        println("NavHostController Exception - ${e.message}")
    }
}
