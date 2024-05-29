package pro.carberry.multiplatform.theme

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@[Stable Composable]
fun DefaultOutlinedTextFieldTheme() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = AppTheme.colors.primaryText,
    unfocusedTextColor = AppTheme.colors.primaryText,
    focusedContainerColor = AppTheme.colors.primaryBackground,
    unfocusedContainerColor = AppTheme.colors.primaryBackground,
    cursorColor = AppTheme.colors.secondaryText,
    disabledBorderColor = AppTheme.colors.secondaryBackground,
    focusedBorderColor = AppTheme.colors.secondaryText,
    errorBorderColor = AppTheme.colors.error,
    unfocusedBorderColor = AppTheme.colors.secondaryBackground
)
