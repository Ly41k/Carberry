package pro.carberry.multiplatform.features.auth.register.presentation.models

sealed interface RegistrationEvent {
    data object BackClick : RegistrationEvent
}
