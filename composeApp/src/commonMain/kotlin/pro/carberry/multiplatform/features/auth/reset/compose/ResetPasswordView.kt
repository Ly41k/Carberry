package pro.carberry.multiplatform.features.auth.reset.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.confirm_new_password
import carberry.composeapp.generated.resources.create_new_password
import carberry.composeapp.generated.resources.new_password
import carberry.composeapp.generated.resources.refund_policy
import carberry.composeapp.generated.resources.terms_of_service
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.core.compose.button.CarberryActionButton
import pro.carberry.multiplatform.core.compose.button.CarberryOutlinedTextField
import pro.carberry.multiplatform.core.compose.icon.PasswordTrailingIcon
import pro.carberry.multiplatform.core.compose.text.CarberryTextLeft
import pro.carberry.multiplatform.features.auth.reset.presentation.models.ResetPasswordEvent
import pro.carberry.multiplatform.features.auth.reset.presentation.models.ResetPasswordViewState
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun ResetPasswordView(
    state: ResetPasswordViewState,
    eventHandler: (ResetPasswordEvent) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            style = AppTheme.typography.mediumHeading,
            text = stringResource(Res.string.create_new_password),
            color = AppTheme.colors.primaryText,
            textAlign = TextAlign.Center
        )

        CarberryOutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(top = 56.dp),
            text = state.newPassword,
            hint = stringResource(Res.string.new_password),
            enabled = true,
            isSecure = !state.isNewPasswordShowed,
            trailingIcon = {
                PasswordTrailingIcon(state.isNewPasswordShowed) { eventHandler.invoke(ResetPasswordEvent.NewPasswordShowsClick) }
            },
            onValueChanged = { eventHandler(ResetPasswordEvent.NewPasswordValueChanged(it)) }
        )

        CarberryOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            text = state.confirmNewPassword,
            hint = stringResource(Res.string.confirm_new_password),
            enabled = true,
            isSecure = !state.isConfirmNewPasswordShowed,
            trailingIcon = {
                PasswordTrailingIcon(state.isConfirmNewPasswordShowed) { eventHandler.invoke(ResetPasswordEvent.ConfirmPasswordShowsClick) }
            },
            onValueChanged = { eventHandler(ResetPasswordEvent.ConfirmNewPasswordValueChanged(it)) }
        )

        CarberryActionButton(
            modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
            text = stringResource(Res.string.create_new_password),
            enabled = true,
            onClick = { eventHandler(ResetPasswordEvent.ResetPasswordClick) }
        )

        CarberryTextLeft(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            stringRes = Res.string.refund_policy,
            onClick = { eventHandler(ResetPasswordEvent.RefundPolicyClick) }
        )

        CarberryTextLeft(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            stringRes = Res.string.terms_of_service,
            onClick = { eventHandler(ResetPasswordEvent.TermsOfServiceClick) }
        )
    }
}
