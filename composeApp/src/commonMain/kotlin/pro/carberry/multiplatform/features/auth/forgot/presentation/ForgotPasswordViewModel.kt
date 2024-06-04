package pro.carberry.multiplatform.features.auth.forgot.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction.OpenLoginScreen
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction.OpenRefundPolicy
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction.OpenRegistrationScreen
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction.OpenResetPassword
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction.OpenTermsOfService
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordEvent
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordEvent.EmailValueChanged
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordEvent.LoginClick
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordEvent.RefundPolicyClick
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordEvent.RegisterClick
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordEvent.ResetPasswordClick
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordEvent.TermsOfServiceClick
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordViewState

class ForgotPasswordViewModel : BaseViewModel<ForgotPasswordViewState, ForgotPasswordAction, ForgotPasswordEvent>(
    initialState = ForgotPasswordViewState()
) {
    override fun obtainEvent(viewEvent: ForgotPasswordEvent) {
        when (viewEvent) {
            is EmailValueChanged -> obtainEmailChanged(viewEvent.value)
            LoginClick -> openLogin()
            RefundPolicyClick -> openRefundPolicy()
            RegisterClick -> openRegistration()
            ResetPasswordClick -> sendResetPassword()
            TermsOfServiceClick -> openTermsOfService()
        }
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(emailValue = value)
    }

    private fun openLogin() {
        viewAction = OpenLoginScreen
    }

    private fun openRefundPolicy() {
        viewAction = OpenRefundPolicy
    }

    private fun openTermsOfService() {
        viewAction = OpenTermsOfService
    }

    private fun openRegistration() {
        viewAction = OpenRegistrationScreen
    }

    private fun sendResetPassword() {
        viewAction = OpenResetPassword
    }
}
