package pro.carberry.multiplatform.features.splash.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.features.splash.presentation.SplashViewModel
import pro.carberry.multiplatform.features.splash.presentation.models.SplashAction

@Composable
fun SplashScreen(viewModel: SplashViewModel = viewModel { SplashViewModel() }) {
    val viewAction by viewModel.viewActions().observeAsState()


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
