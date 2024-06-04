package pro.carberry.multiplatform.features.splash.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.ic_logo_vertical
import org.jetbrains.compose.resources.painterResource
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun SplashView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(Res.drawable.ic_logo_vertical),
            contentDescription = null,
            colorFilter = ColorFilter.tint(AppTheme.colors.primaryAction)
        )
    }
}
