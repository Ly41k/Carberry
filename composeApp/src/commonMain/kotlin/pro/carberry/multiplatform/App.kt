package pro.carberry.multiplatform

import androidx.compose.runtime.Composable
import pro.carberry.multiplatform.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    CarberryApp()
}

internal expect fun openUrl(url: String?)
