package pro.carberry.multiplatform.features.auth.login.presentation

import kotlinx.coroutines.flow.StateFlow
import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginViewState

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>() {

    override fun viewStates(): StateFlow<LoginViewState> = TODO()

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {

        }
    }
}
