package pro.carberry.multiplatform.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import pro.carberry.multiplatform.theme.models.AppColors
import pro.carberry.multiplatform.theme.models.AppTypographies

internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
internal fun AppTheme(
    content: @Composable() () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }
    val isDark by isDarkState
    val colors = if (isDark) darkColorScheme else lightColorScheme

    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalAppColors provides colors,
        LocalAppTypographies provides typography,
    ) {
        SystemAppearance(!isDark)
        Surface(content = content)
    }
}

object AppTheme {
    val colors: AppColors
        @Composable get() = LocalAppColors.current

    val typography: AppTypographies
        @Composable get() = LocalAppTypographies.current
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
