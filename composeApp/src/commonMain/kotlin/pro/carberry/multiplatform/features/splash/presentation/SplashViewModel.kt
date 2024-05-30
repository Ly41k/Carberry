package pro.carberry.multiplatform.features.splash.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction

class SplashViewModel : BaseViewModel<Unit, SplashAction, Unit>(Unit) {

    init {
        checkUserStatus()
    }

    override fun obtainEvent(viewEvent: Unit) {}

    private fun checkUserStatus() {
        viewAction = when {
            !isUserPassedOnboarding() -> SplashAction.OpenOnboardingScreen
            isUserAuthorized() -> SplashAction.OpenLoginScreen
            else -> SplashAction.OpenMainScreen
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
