package pro.carberry.multiplatform.features.auth.login.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pro.carberry.multiplatform.core.compose.button.CarberryActionButton
import pro.carberry.multiplatform.core.compose.button.CarberryOutlinedTextField
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginViewState
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun LoginView(
    state: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {

    Column(
        modifier = Modifier.padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Now",
            color = AppTheme.colors.primaryText,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Welcome back to Carberry!",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = AppTheme.colors.secondaryText
        )

        Spacer(modifier = Modifier.height(50.dp))

        CarberryOutlinedTextField(
            modifier = Modifier,
            text = state.emailValue,
            hint = "Login",
            enabled = true,
            onValueChanged = { eventHandler(LoginEvent.EmailValueChanged(it)) }
        )

        CarberryOutlinedTextField(
            modifier = Modifier,
            text = state.passwordValue,
            hint = "Password",
            enabled = true,
            isSecure = true,
            onValueChanged = { eventHandler(LoginEvent.PasswordValueChanged(it)) }
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.clickable { },
                text = "Forgot password", color = AppTheme.colors.primaryAction,
                fontSize = 12.sp
            )
        }

        CarberryActionButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Login",
            enabled = true,
            onClick = {
//                navAction.invoke(LoginAction.OpenMainScreen)
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.clickable { },
                text = "Refund policy", color = AppTheme.colors.primaryAction,
                fontSize = 12.sp
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.clickable { },
                text = "Terms of service", color = AppTheme.colors.primaryAction,
                fontSize = 12.sp
            )
        }
    }
}