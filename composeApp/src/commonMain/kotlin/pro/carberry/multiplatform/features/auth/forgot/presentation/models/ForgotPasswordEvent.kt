package pro.carberry.multiplatform.features.auth.forgot.presentation.models

sealed interface ForgotPasswordEvent {
    data class EmailValueChanged(val value: String) : ForgotPasswordEvent
    data object ResetPasswordClick : ForgotPasswordEvent
    data object RegisterClick : ForgotPasswordEvent
    data object LoginClick : ForgotPasswordEvent
    data object RefundPolicyClick : ForgotPasswordEvent
    data object TermsOfServiceClick : ForgotPasswordEvent
}
