package pro.carberry.multiplatform.features.auth.register.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pro.carberry.multiplatform.core.compose.button.CarberryActionButton
import pro.carberry.multiplatform.features.auth.register.presentation.models.RegistrationEvent
import pro.carberry.multiplatform.features.auth.register.presentation.models.RegistrationEvent.BackClick
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun RegistrationView(
    eventHandler: (RegistrationEvent) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth().systemBarsPadding().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            style = AppTheme.typography.mediumHeading,
            text = "Registration",
            color = AppTheme.colors.primaryText,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            style = AppTheme.typography.smallHeading,
            text = "Will be added soon",
            textAlign = TextAlign.Center,
            color = AppTheme.colors.secondaryText
        )

        CarberryActionButton(
            modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
            text = "Back",
            enabled = true,
            onClick = { eventHandler(BackClick) }
        )
    }
}
