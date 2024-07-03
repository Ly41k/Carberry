package pro.carberry.multiplatform.features.auth.register.presentation.models

sealed interface RegistrationAction {
    data object OpenPreviousScreen : RegistrationAction
}
