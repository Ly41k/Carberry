package pro.carberry.multiplatform.features.auth.login.presentation.models

sealed interface LoginEvent {
    data class EmailValueChanged(val value: String) : LoginEvent
    data class PasswordValueChanged(val value: String) : LoginEvent
    data object PasswordShowsClick : LoginEvent
    data object ForgotPasswordClick : LoginEvent
    data object RegisterClick : LoginEvent
    data object LoginClick : LoginEvent
    data object RefundPolicyClick : LoginEvent
    data object TermsOfServiceClick : LoginEvent
}
