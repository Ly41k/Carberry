package pro.carberry.multiplatform.features.splash.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.di.LocalPlatform
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.features.splash.presentation.SplashViewModel
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun SplashScreen(viewModel: SplashViewModel = viewModel { SplashViewModel() }) {
    val viewAction by viewModel.viewActions().observeAsState()

    val platform = LocalPlatform.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.primaryBackground),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = platform.name,
            style = AppTheme.typography.largeHeading,
            color = AppTheme.colors.primaryText,
            textAlign = TextAlign.Center
        )
    }

    when (viewAction) {
        SplashAction.OpenLoginScreen -> {

        }

        SplashAction.OpenMainScreen -> {

        }

        SplashAction.OpenOnboardingScreen -> {

        }

        null -> {
            /* Do nothing*/
        }
    }
}
