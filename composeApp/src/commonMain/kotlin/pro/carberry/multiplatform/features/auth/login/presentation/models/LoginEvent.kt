package pro.carberry.multiplatform.features.auth.login.presentation.models

sealed interface LoginEvent {
    data class EmailValueChanged(val value: String) : LoginEvent
    data class PasswordValueChanged(val value: String) : LoginEvent
}
