package pro.carberry.multiplatform.features.auth.login.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateToRefundPolicy
import pro.carberry.multiplatform.core.naviagtion.navigateToTermsOfService
import pro.carberry.multiplatform.features.auth.login.presentation.LoginViewModel
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenForgotPasswordScreen
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenMainFlow
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenRefundPolicy
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenRegistrationScreen
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenTermsOfService
import pro.carberry.multiplatform.navigation.RootAppScreens

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel { LoginViewModel() }
) {

    val navController = LocalRootNavHostController.current

    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()
    LoginView(state) { event -> viewModel.obtainEvent(event) }

    when (action) {
        OpenForgotPasswordScreen -> {
            navController.navigate(RootAppScreens.ForgotPassword.name)
            viewModel.clearAction()
        }

        OpenMainFlow -> {
            navController.popBackStack()
            navController.navigate(RootAppScreens.Main.name)
        }

        OpenRefundPolicy -> {
            navController.navigateToRefundPolicy()
        }

        OpenRegistrationScreen -> {
            navController.navigate(RootAppScreens.Register.name)
        }

        OpenTermsOfService -> {
            navController.navigateToTermsOfService()
        }

        null -> {
            /* Do nothing*/
        }
    }
}
