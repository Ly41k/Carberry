package pro.carberry.multiplatform.features.auth.reset.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.auth.reset.presentation.models.ResetPasswordAction
import pro.carberry.multiplatform.features.auth.reset.presentation.models.ResetPasswordEvent
import pro.carberry.multiplatform.features.auth.reset.presentation.models.ResetPasswordViewState

class ResetPasswordViewModel : BaseViewModel<ResetPasswordViewState, ResetPasswordAction, ResetPasswordEvent>(
    initialState = ResetPasswordViewState()
) {
    override fun obtainEvent(viewEvent: ResetPasswordEvent) {
        when (viewEvent) {
            ResetPasswordEvent.ConfirmPasswordShowsClick -> changeConfirmNewPasswordVisibility()
            is ResetPasswordEvent.ConfirmNewPasswordValueChanged -> obtainConfirmNewPasswordChanged(viewEvent.value)
            ResetPasswordEvent.NewPasswordShowsClick -> changeNewPasswordVisibility()
            is ResetPasswordEvent.NewPasswordValueChanged -> obtainNewPasswordChanged(viewEvent.value)
            ResetPasswordEvent.RefundPolicyClick -> openRefundPolicy()
            ResetPasswordEvent.ResetPasswordClick -> sendResetPassword()
            ResetPasswordEvent.TermsOfServiceClick -> openTermsOfService()
        }
    }

    private fun sendResetPassword() {
        viewAction = ResetPasswordAction.OpenLoginPassword
    }

    private fun obtainNewPasswordChanged(value: String) {
        viewState = viewState.copy(newPassword = value)
    }

    private fun obtainConfirmNewPasswordChanged(value: String) {
        viewState = viewState.copy(confirmNewPassword = value)
    }

    private fun changeNewPasswordVisibility() {
        viewState = viewState.copy(isNewPasswordShowed = !viewState.isNewPasswordShowed)
    }

    private fun changeConfirmNewPasswordVisibility() {
        viewState = viewState.copy(isConfirmNewPasswordShowed = !viewState.isConfirmNewPasswordShowed)
    }

    private fun openRefundPolicy() {
        viewAction = ResetPasswordAction.OpenRefundPolicy
    }

    private fun openTermsOfService() {
        viewAction = ResetPasswordAction.OpenTermsOfService
    }
}
