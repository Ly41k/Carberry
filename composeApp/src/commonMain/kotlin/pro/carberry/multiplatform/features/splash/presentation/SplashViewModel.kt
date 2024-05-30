package pro.carberry.multiplatform.features.splash.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction.OpenLoginScreen
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction.OpenMainScreen
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction.OpenOnboardingScreen

class SplashViewModel : BaseViewModel<Unit, SplashAction, Unit>(Unit) {

    init {
        checkUserStatus()
    }

    override fun obtainEvent(viewEvent: Unit) {}

    private fun checkUserStatus() {
        viewAction = when {
            !isUserPassedOnboarding() -> OpenOnboardingScreen
            isUserAuthorized() -> OpenLoginScreen
            else -> OpenMainScreen
        }
    }

    private fun isUserPassedOnboarding(): Boolean {
        //TODO need to check if the user has been passed onboarding
        return true
    }

    private fun isUserAuthorized(): Boolean {
        //TODO need to check if the user has been logged in
        return true
    }
}
