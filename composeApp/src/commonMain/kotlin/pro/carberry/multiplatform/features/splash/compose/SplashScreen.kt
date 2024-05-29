package pro.carberry.multiplatform.features.splash.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.ic_logo_vertical
import org.jetbrains.compose.resources.painterResource
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateToLogin
import pro.carberry.multiplatform.core.naviagtion.navigateToMain
import pro.carberry.multiplatform.core.naviagtion.navigateToOnboarding
import pro.carberry.multiplatform.features.splash.presentation.SplashViewModel
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun SplashScreen(viewModel: SplashViewModel = viewModel { SplashViewModel() }) {
    val navController = LocalRootNavHostController.current

    val viewAction by viewModel.viewActions().observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.primaryBackground),
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

    when (viewAction) {
        SplashAction.OpenLoginScreen -> navController.navigateToLogin()
        SplashAction.OpenMainScreen -> navController.navigateToMain()
        SplashAction.OpenOnboardingScreen -> navController.navigateToOnboarding()
        null -> {
            /* Do nothing*/
        }
    }
}
