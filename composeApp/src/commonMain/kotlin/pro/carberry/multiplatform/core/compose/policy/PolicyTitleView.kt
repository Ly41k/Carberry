package pro.carberry.multiplatform.core.compose.policy

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.theme.AppTheme

@[Composable Stable]
fun PolicyTitleView(title: StringResource) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = AppTheme.colors.secondaryText
        )
        Text(
            modifier = Modifier.padding(horizontal = 6.dp),
            text = stringResource(title),
            color = AppTheme.colors.secondaryText,
            style = AppTheme.typography.smallHeading
        )
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = AppTheme.colors.secondaryText
        )
    }
}
