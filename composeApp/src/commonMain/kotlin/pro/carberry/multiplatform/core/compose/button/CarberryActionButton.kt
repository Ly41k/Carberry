package pro.carberry.multiplatform.core.compose.button

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pro.carberry.multiplatform.theme.AppTheme

@[Stable Composable]
fun CarberryActionButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .heightIn(min = 48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.primaryAction,
            disabledContainerColor = AppTheme.colors.primaryAction.copy(alpha = 0.5f)
        ),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        onClick = { onClick.invoke() }) {
        Text(
            text = text,
            color = AppTheme.colors.primaryText,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
    }
}
