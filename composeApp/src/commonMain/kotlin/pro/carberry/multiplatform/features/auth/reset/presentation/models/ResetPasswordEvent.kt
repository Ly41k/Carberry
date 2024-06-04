package pro.carberry.multiplatform.features.auth.reset.presentation.models

sealed interface ResetPasswordEvent {
    data class NewPasswordValueChanged(val value: String) : ResetPasswordEvent
    data class ConfirmNewPasswordValueChanged(val value: String) : ResetPasswordEvent
    data object NewPasswordShowsClick : ResetPasswordEvent
    data object ConfirmPasswordShowsClick : ResetPasswordEvent
    data object ResetPasswordClick : ResetPasswordEvent
    data object RefundPolicyClick : ResetPasswordEvent
    data object TermsOfServiceClick : ResetPasswordEvent
}