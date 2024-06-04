package pro.carberry.multiplatform.features.auth.reset.presentation.models

data class ResetPasswordViewState(
    val newPassword: String = "",
    val confirmNewPassword: String = "",
    val isNewPasswordShowed: Boolean = false,
    val isConfirmNewPasswordShowed: Boolean = false,
    val isResetPasswordDataSending: Boolean = false
)
