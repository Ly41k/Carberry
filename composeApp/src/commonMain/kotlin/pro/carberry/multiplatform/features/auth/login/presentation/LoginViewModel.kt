package pro.carberry.multiplatform.features.auth.login.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginViewState

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>(LoginViewState()) {

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.EmailValueChanged -> obtainEmailChanged(viewEvent.value)
            is LoginEvent.PasswordValueChanged -> obtainPasswordChanged(viewEvent.value)
        }
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(emailValue = value)
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(passwordValue = value)
    }
}
