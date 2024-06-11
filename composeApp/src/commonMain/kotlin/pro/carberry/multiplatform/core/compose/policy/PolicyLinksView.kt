package pro.carberry.multiplatform.core.compose.policy

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.theme.AppTheme

@[Composable Stable]
fun PolicyLinksView(
    startLinkName: StringResource,
    endLinkName: StringResource,
    onStartLinkClick: () -> Unit,
    onEndLinkClick: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
        Text(
            modifier = Modifier.clickable { onStartLinkClick() },
            text = stringResource(startLinkName),
            style = AppTheme.typography.mediumText,
            color = AppTheme.colors.primaryAction
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.clickable { onEndLinkClick() },
            text = stringResource(endLinkName),
            style = AppTheme.typography.mediumText,
            color = AppTheme.colors.primaryAction
        )
    }
}
