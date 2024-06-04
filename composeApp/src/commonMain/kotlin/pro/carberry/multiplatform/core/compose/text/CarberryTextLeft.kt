package pro.carberry.multiplatform.core.compose.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.theme.AppTheme

@[Stable Composable]
fun CarberryTextLeft(
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
