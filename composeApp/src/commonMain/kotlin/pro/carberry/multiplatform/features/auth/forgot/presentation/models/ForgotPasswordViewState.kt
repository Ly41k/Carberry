package pro.carberry.multiplatform.features.auth.forgot.presentation.models

data class ForgotPasswordViewState(
    val emailValue: String = "",
    val isEmailSending: Boolean = false
)
