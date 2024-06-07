package pro.carberry.multiplatform.features.auth.login.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenForgotPasswordScreen
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenMainFlow
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenRefundPolicy
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenRegistrationScreen
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenTermsOfService
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.EmailValueChanged
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.ForgotPasswordClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.LoginClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.PasswordShowsClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.PasswordValueChanged
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.RefundPolicyClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.RegisterClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.TermsOfServiceClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginViewState

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>(LoginViewState()) {

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is EmailValueChanged -> obtainEmailChanged(viewEvent.value)
            is PasswordValueChanged -> obtainPasswordChanged(viewEvent.value)
            PasswordShowsClick -> changePasswordVisibility()
            ForgotPasswordClick -> openForgotPassword()
            LoginClick -> sendLogin()
            RefundPolicyClick -> openRefundPolicy()
            TermsOfServiceClick -> openTermsOfService()
            RegisterClick -> openRegistration()
        }
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(emailValue = value)
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(passwordValue = value)
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(isPasswordShowed = !viewState.isPasswordShowed)
    }

    private fun openRegistration() {
        viewAction = OpenRegistrationScreen
    }

    private fun openForgotPassword() {
        viewAction = OpenForgotPasswordScreen
    }

    private fun sendLogin() {
        viewAction = OpenMainFlow
    }

    private fun openRefundPolicy() {
        viewAction = OpenRefundPolicy
    }

    private fun openTermsOfService() {
        viewAction = OpenTermsOfService
    }
}
