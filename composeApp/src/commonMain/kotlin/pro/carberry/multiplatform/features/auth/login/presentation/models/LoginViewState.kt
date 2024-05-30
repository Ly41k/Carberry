package pro.carberry.multiplatform.features.auth.login.presentation.models

data class LoginViewState(
    val emailValue: String = "",
    val passwordValue: String = "",
    val isPasswordShowed: Boolean = false,
    val isLoginDataSending: Boolean = false
)
