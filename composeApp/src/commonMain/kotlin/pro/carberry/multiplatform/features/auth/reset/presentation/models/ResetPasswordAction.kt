package pro.carberry.multiplatform.features.auth.reset.presentation.models

sealed interface ResetPasswordAction {
    data object OpenLoginPassword : ResetPasswordAction
    data object OpenRefundPolicy : ResetPasswordAction
    data object OpenTermsOfService : ResetPasswordAction
}
