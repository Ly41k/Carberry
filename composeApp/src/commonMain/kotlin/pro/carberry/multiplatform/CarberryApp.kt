package pro.carberry.multiplatform

import androidx.compose.runtime.Composable
import pro.carberry.multiplatform.navigation.RootAppGraph
import pro.carberry.multiplatform.theme.AppTheme

@Composable
internal fun CarberryApp() = AppTheme {
    RootAppGraph()
}
