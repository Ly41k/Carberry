package pro.carberry.multiplatform.features.auth.login.presentation.models

sealed interface LoginAction {
    data object OpenRegistrationScreen : LoginAction
    data object OpenForgotPasswordScreen : LoginAction
    data object OpenMainFlow : LoginAction
    data object OpenRefundPolicy : LoginAction
    data object OpenTermsOfService : LoginAction
}
