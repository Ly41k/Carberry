package pro.carberry.multiplatform.features.splash.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import carberry.composeapp.generated.resources.Canavar
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun SplashView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(Res.string.app_name),
            textAlign = TextAlign.Center,
            color = AppTheme.colors.primaryText,
            style = AppTheme.typography.largeHeading,
            fontFamily = FontFamily(Font(Res.font.Canavar))
        )
    }
}
