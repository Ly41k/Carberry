package pro.carberry.multiplatform.features.auth.login.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.LockOpen
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.create_one
import carberry.composeapp.generated.resources.do_not_have_account
import carberry.composeapp.generated.resources.email
import carberry.composeapp.generated.resources.forgot_password
import carberry.composeapp.generated.resources.login
import carberry.composeapp.generated.resources.login_now
import carberry.composeapp.generated.resources.password
import carberry.composeapp.generated.resources.password_hidden
import carberry.composeapp.generated.resources.password_shown
import carberry.composeapp.generated.resources.refund_policy
import carberry.composeapp.generated.resources.terms_of_service
import carberry.composeapp.generated.resources.welcome_back_to_carberry
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.core.compose.button.CarberryActionButton
import pro.carberry.multiplatform.core.compose.button.CarberryOutlinedTextField
import pro.carberry.multiplatform.core.extensions.noRippleClickable
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.EmailValueChanged
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.ForgotPasswordClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.LoginClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.PasswordShowsClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.PasswordValueChanged
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.RefundPolicyClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent.TermsOfServiceClick
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginViewState
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun LoginView(
    state: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                style = AppTheme.typography.largeHeading,
                text = stringResource(Res.string.login_now),
                color = AppTheme.colors.primaryText,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                style = AppTheme.typography.smallHeading,
                text = stringResource(Res.string.welcome_back_to_carberry),
                textAlign = TextAlign.Center,
                color = AppTheme.colors.secondaryText
            )

            CarberryOutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(top = 48.dp),
                text = state.emailValue,
                hint = stringResource(Res.string.email),
                enabled = true,
                onValueChanged = { eventHandler(EmailValueChanged(it)) }
            )

            CarberryOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                text = state.passwordValue,
                hint = stringResource(Res.string.password),
                enabled = true,
                isSecure = !state.isPasswordShowed,
                trailingIcon = {
                    PasswordTrailingIcon(state.isPasswordShowed) { eventHandler.invoke(PasswordShowsClick) }
                },
                onValueChanged = { eventHandler(PasswordValueChanged(it)) }
            )

            TextLeft(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                stringRes = Res.string.forgot_password,
                onClick = { eventHandler(ForgotPasswordClick) }
            )

            CarberryActionButton(
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                text = stringResource(Res.string.login),
                enabled = true,
                onClick = { eventHandler(LoginClick) }
            )

            TextLeft(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                stringRes = Res.string.refund_policy,
                onClick = { eventHandler(RefundPolicyClick) }
            )

            TextLeft(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                stringRes = Res.string.terms_of_service,
                onClick = { eventHandler(TermsOfServiceClick) }
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
                modifier = Modifier.clickable { eventHandler(LoginEvent.RegisterClick) },
                style = AppTheme.typography.smallHeading,
                text = stringResource(Res.string.create_one),
                textAlign = TextAlign.Center,
                color = AppTheme.colors.primaryAction
            )
        }
    }
}

@[Stable Composable]
private fun PasswordTrailingIcon(isPasswordShowed: Boolean, onClick: () -> Unit) {
    Icon(
        modifier = Modifier.noRippleClickable { onClick() },
        imageVector = if (isPasswordShowed) Icons.Outlined.Lock else Icons.Outlined.LockOpen,
        tint = AppTheme.colors.secondaryText,
        contentDescription = stringResource(
            if (isPasswordShowed) Res.string.password_shown else Res.string.password_hidden
        )
    )
}

@[Stable Composable]
private fun TextLeft(
    modifier: Modifier,
    stringRes: StringResource,
    onClick: () -> Unit
) {
    Row(modifier = modifier) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.clickable { onClick() },
            style = AppTheme.typography.mediumText,
            text = stringResource(stringRes),
            color = AppTheme.colors.primaryAction,
        )
    }
}
