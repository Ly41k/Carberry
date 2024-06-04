package pro.carberry.multiplatform.features.auth.forgot.presentation.models

sealed interface ForgotPasswordAction {
    data object OpenRegistrationScreen : ForgotPasswordAction
    data object OpenLoginScreen : ForgotPasswordAction
    data object OpenResetPassword : ForgotPasswordAction
    data object OpenRefundPolicy : ForgotPasswordAction
    data object OpenTermsOfService : ForgotPasswordAction
}
