package pro.carberry.multiplatform.features.auth.forgot.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.create_one
import carberry.composeapp.generated.resources.do_not_have_account
import carberry.composeapp.generated.resources.email
import carberry.composeapp.generated.resources.forgot_password
import carberry.composeapp.generated.resources.forgot_password_description
import carberry.composeapp.generated.resources.login
import carberry.composeapp.generated.resources.refund_policy
import carberry.composeapp.generated.resources.reset_password
import carberry.composeapp.generated.resources.terms_of_service
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.core.compose.button.CarberryActionButton
import pro.carberry.multiplatform.core.compose.button.CarberryOutlinedTextField
import pro.carberry.multiplatform.core.compose.text.CarberryTextLeft
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordEvent
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordViewState
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun ForgotPasswordView(
    state: ForgotPasswordViewState,
    eventHandler: (ForgotPasswordEvent) -> Unit
) {

    Column(modifier = Modifier.fillMaxSize().systemBarsPadding().padding(24.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                style = AppTheme.typography.mediumHeading,
                text = stringResource(Res.string.forgot_password),
                color = AppTheme.colors.primaryText,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                style = AppTheme.typography.smallHeading,
                text = stringResource(Res.string.forgot_password_description),
                textAlign = TextAlign.Center,
                color = AppTheme.colors.secondaryText
            )

            CarberryOutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(top = 48.dp),
                text = state.emailValue,
                hint = stringResource(Res.string.email),
                enabled = true,
                onValueChanged = { eventHandler(ForgotPasswordEvent.EmailValueChanged(it)) }
            )

            CarberryTextLeft(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                stringRes = Res.string.login,
                onClick = { eventHandler(ForgotPasswordEvent.LoginClick) }
            )

            CarberryActionButton(
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                text = stringResource(Res.string.reset_password),
                enabled = true,
                onClick = { eventHandler(ForgotPasswordEvent.ResetPasswordClick) }
            )

            CarberryTextLeft(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                stringRes = Res.string.refund_policy,
                onClick = { eventHandler(ForgotPasswordEvent.RefundPolicyClick) }
            )

            CarberryTextLeft(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                stringRes = Res.string.terms_of_service,
                onClick = { eventHandler(ForgotPasswordEvent.TermsOfServiceClick) }
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = Modifier.padding(end = 4.dp),
                style = AppTheme.typography.smallHeading,
                text = stringResource(Res.string.do_not_have_account),
                textAlign = TextAlign.Center,
                color = AppTheme.colors.secondaryText
            )

            Text(
                modifier = Modifier.clickable { eventHandler(ForgotPasswordEvent.RegisterClick) },
                style = AppTheme.typography.smallHeading,
                text = stringResource(Res.string.create_one),
                textAlign = TextAlign.Center,
                color = AppTheme.colors.primaryAction
            )
        }
    }
}
