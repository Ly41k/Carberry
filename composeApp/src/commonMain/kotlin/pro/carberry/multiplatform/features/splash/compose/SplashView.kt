package pro.carberry.multiplatform.features.splash.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pro.carberry.multiplatform.core.compose.loader.CircleLoader
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun SplashView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircleLoader(
            color = AppTheme.colors.primaryAction,
            modifier = Modifier.size(96.dp),
            isVisible = true
        )
    }
}
