package pro.carberry.multiplatform.features.auth.login.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateWithClearAction
import pro.carberry.multiplatform.core.naviagtion.navigateWithPopBackStack
import pro.carberry.multiplatform.features.auth.login.presentation.LoginViewModel
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenForgotPasswordScreen
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenMainFlow
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenRefundPolicy
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenRegistrationScreen
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction.OpenTermsOfService
import pro.carberry.multiplatform.navigation.AuthAppScreens.ForgotPassword
import pro.carberry.multiplatform.navigation.AuthAppScreens.Register
import pro.carberry.multiplatform.navigation.PolicyAppScreens.Refund
import pro.carberry.multiplatform.navigation.PolicyAppScreens.TermsOfService
import pro.carberry.multiplatform.navigation.RootAppScreens.Main

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel { LoginViewModel() }
) {

    val navController = LocalRootNavHostController.current

    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()
    LoginView(state) { event -> viewModel.obtainEvent(event) }

    when (action) {
        OpenForgotPasswordScreen -> navController.navigateWithClearAction(ForgotPassword.name, viewModel::clearAction)
        OpenMainFlow -> navController.navigateWithPopBackStack(Main.name)
        OpenRefundPolicy -> navController.navigateWithClearAction(Refund.name, viewModel::clearAction)
        OpenRegistrationScreen -> navController.navigateWithClearAction(Register.name, viewModel::clearAction)
        OpenTermsOfService -> navController.navigateWithClearAction(TermsOfService.name, viewModel::clearAction)
        null -> {
            /* Do nothing*/
        }
    }
}
