package pro.carberry.multiplatform.features.auth.register.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.auth.register.presentation.models.RegistrationAction
import pro.carberry.multiplatform.features.auth.register.presentation.models.RegistrationAction.OpenPreviousScreen
import pro.carberry.multiplatform.features.auth.register.presentation.models.RegistrationEvent
import pro.carberry.multiplatform.features.auth.register.presentation.models.RegistrationEvent.BackClick

class RegistrationViewModel : BaseViewModel<Unit, RegistrationAction, RegistrationEvent>(
    initialState = Unit
) {
    override fun obtainEvent(viewEvent: RegistrationEvent) {
        when (viewEvent) {
            BackClick -> openPreviousScreen()
        }
    }

    private fun openPreviousScreen() {
        viewAction = OpenPreviousScreen
    }
}
