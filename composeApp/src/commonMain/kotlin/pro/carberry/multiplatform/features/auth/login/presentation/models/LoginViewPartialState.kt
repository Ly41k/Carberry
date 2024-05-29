package pro.carberry.multiplatform.features.auth.login.presentation.models

sealed interface LoginViewPartialState {
    data class EmailValueChanged(val value: String) : LoginViewPartialState
    data class PasswordValueChanged(val value: String) : LoginViewPartialState
}
