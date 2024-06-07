package pro.carberry.multiplatform.features.auth.forgot.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateWithClearAction
import pro.carberry.multiplatform.features.auth.forgot.presentation.ForgotPasswordViewModel
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction.OpenLoginScreen
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction.OpenRefundPolicy
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction.OpenRegistrationScreen
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction.OpenResetPassword
import pro.carberry.multiplatform.features.auth.forgot.presentation.models.ForgotPasswordAction.OpenTermsOfService
import pro.carberry.multiplatform.navigation.AuthAppScreens.Login
import pro.carberry.multiplatform.navigation.AuthAppScreens.Register
import pro.carberry.multiplatform.navigation.AuthAppScreens.ResetPassword
import pro.carberry.multiplatform.navigation.PolicyAppScreens.Refund
import pro.carberry.multiplatform.navigation.PolicyAppScreens.TermsOfService

@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel = viewModel { ForgotPasswordViewModel() }
) {

    val navController = LocalRootNavHostController.current

    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()
    ForgotPasswordView(state) { event -> viewModel.obtainEvent(event) }

    when (action) {
        OpenLoginScreen -> navController.popBackStack(route = Login.name, inclusive = false)
        OpenRefundPolicy -> navController.navigateWithClearAction(Refund.name, viewModel::clearAction)
        OpenRegistrationScreen -> navController.navigateWithClearAction(Register.name, viewModel::clearAction)
        OpenResetPassword -> navController.navigateWithClearAction(ResetPassword.name, viewModel::clearAction)
        OpenTermsOfService -> navController.navigateWithClearAction(TermsOfService.name, viewModel::clearAction)
        null -> {
            /* Do nothing*/
        }
    }
}
