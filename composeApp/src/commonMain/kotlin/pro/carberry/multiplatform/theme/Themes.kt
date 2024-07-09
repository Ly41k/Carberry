package pro.carberry.multiplatform.theme

import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@[Stable Composable]
fun DefaultOutlinedTextFieldColors() = OutlinedTextFieldDefaults.colors(
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

@[Stable Composable]
fun DefaultNavigationBarItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = AppTheme.colors.primaryAction,
    unselectedIconColor = AppTheme.colors.primaryText,
    unselectedTextColor = AppTheme.colors.primaryText.copy(.9f),
    selectedTextColor = AppTheme.colors.primaryAction,
    indicatorColor = AppTheme.colors.primaryBackground
)
