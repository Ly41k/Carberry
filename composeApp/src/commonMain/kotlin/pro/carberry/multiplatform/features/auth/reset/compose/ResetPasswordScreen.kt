package pro.carberry.multiplatform.features.auth.reset.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateWithClearAction
import pro.carberry.multiplatform.features.auth.reset.presentation.ResetPasswordViewModel
import pro.carberry.multiplatform.features.auth.reset.presentation.models.ResetPasswordAction.OpenLoginPassword
import pro.carberry.multiplatform.features.auth.reset.presentation.models.ResetPasswordAction.OpenRefundPolicy
import pro.carberry.multiplatform.features.auth.reset.presentation.models.ResetPasswordAction.OpenTermsOfService
import pro.carberry.multiplatform.navigation.AuthAppScreens.Login
import pro.carberry.multiplatform.navigation.PolicyAppScreens.Refund
import pro.carberry.multiplatform.navigation.PolicyAppScreens.TermsOfService

@Composable
fun ResetPasswordScreen(
    viewModel: ResetPasswordViewModel = viewModel { ResetPasswordViewModel() }
) {

    val navController = LocalRootNavHostController.current

    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()
    ResetPasswordView(state) { event -> viewModel.obtainEvent(event) }

    when (action) {
        OpenLoginPassword -> navController.popBackStack(route = Login.name, inclusive = false)
        OpenRefundPolicy -> navController.navigateWithClearAction(Refund.name, viewModel::clearAction)
        OpenTermsOfService -> navController.navigateWithClearAction(TermsOfService.name, viewModel::clearAction)
        null -> {
            /* Do nothing*/
        }
    }
}
