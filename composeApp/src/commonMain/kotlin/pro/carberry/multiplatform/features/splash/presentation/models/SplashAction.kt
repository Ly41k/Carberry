package pro.carberry.multiplatform.features.splash.presentation.models

sealed interface SplashAction {
    data object OpenMainScreen : SplashAction
    data object OpenLoginScreen : SplashAction
    data object OpenOnboardingScreen : SplashAction
}
