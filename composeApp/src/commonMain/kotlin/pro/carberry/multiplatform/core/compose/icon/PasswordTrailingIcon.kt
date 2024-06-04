package pro.carberry.multiplatform.core.compose.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.LockOpen
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.password_hidden
import carberry.composeapp.generated.resources.password_shown
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.core.extensions.noRippleClickable
import pro.carberry.multiplatform.theme.AppTheme

@[Stable Composable]
fun PasswordTrailingIcon(isPasswordShowed: Boolean, onClick: () -> Unit) {
    Icon(
        modifier = Modifier.noRippleClickable { onClick() },
        imageVector = if (isPasswordShowed) Icons.Outlined.Lock else Icons.Outlined.LockOpen,
        tint = AppTheme.colors.secondaryText,
        contentDescription = stringResource(
            if (isPasswordShowed) Res.string.password_shown else Res.string.password_hidden
        )
    )
}
