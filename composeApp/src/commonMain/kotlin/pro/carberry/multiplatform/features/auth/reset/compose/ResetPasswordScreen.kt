package pro.carberry.multiplatform.features.auth.reset.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateToRefundPolicy
import pro.carberry.multiplatform.core.naviagtion.navigateToTermsOfService
import pro.carberry.multiplatform.features.auth.reset.presentation.ResetPasswordViewModel
import pro.carberry.multiplatform.features.auth.reset.presentation.models.ResetPasswordAction
import pro.carberry.multiplatform.navigation.RootAppScreens

@Composable
fun ResetPasswordScreen(
    viewModel: ResetPasswordViewModel = viewModel { ResetPasswordViewModel() }
) {

    val navController = LocalRootNavHostController.current

    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()
    ResetPasswordView(state) { event -> viewModel.obtainEvent(event) }

    when (action) {
        ResetPasswordAction.OpenLoginPassword -> {
            navController.popBackStack(
                route = RootAppScreens.Login.name,
                inclusive = false
            )
        }

        ResetPasswordAction.OpenRefundPolicy -> {
            navController.navigateToRefundPolicy()
        }

        ResetPasswordAction.OpenTermsOfService -> {
            navController.navigateToTermsOfService()
        }

        null -> {
            /* Do nothing*/
        }
    }
}
