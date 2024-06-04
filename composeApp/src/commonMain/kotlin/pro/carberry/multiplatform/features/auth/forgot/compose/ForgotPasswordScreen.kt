package pro.carberry.multiplatform.features.auth.forgot.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateToRefundPolicy
import pro.carberry.multiplatform.core.naviagtion.navigateToTermsOfService
import pro.carberry.multiplatform.features.auth.forgot.presentation.ForgotPasswordViewModel
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction
import pro.carberry.multiplatform.navigation.RootAppScreens

@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel = viewModel { ForgotPasswordViewModel() }
) {

    val navController = LocalRootNavHostController.current

    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()
    ForgotPasswordView(state) { event -> viewModel.obtainEvent(event) }

    when (action) {
        ForgotPasswordAction.OpenLoginScreen -> {
            navController.popBackStack(
                route = RootAppScreens.Login.name,
                inclusive = false
            )
        }

        ForgotPasswordAction.OpenRefundPolicy -> {
            navController.navigateToRefundPolicy()
        }

        ForgotPasswordAction.OpenRegistrationScreen -> {
            navController.navigate(RootAppScreens.Register.name)
            viewModel.clearAction()
        }

        ForgotPasswordAction.OpenResetPassword -> {
            navController.navigate(RootAppScreens.ResetPassword.name)
            viewModel.clearAction()
        }

        ForgotPasswordAction.OpenTermsOfService -> {
            navController.navigateToTermsOfService()
        }

        null -> {
            /* Do nothing*/
        }
    }
}
