package pro.carberry.multiplatform.features.policy.refund.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateWithClearAction
import pro.carberry.multiplatform.features.policy.refund.presentation.RefundPolicyViewModel
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction.OpenPreviousScreen
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction.OpenPrivacyPolicy
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction.OpenTermsOfService
import pro.carberry.multiplatform.navigation.PolicyAppScreens.Privacy
import pro.carberry.multiplatform.navigation.PolicyAppScreens.TermsOfService

@Composable
fun RefundPolicyScreen(
    viewModel: RefundPolicyViewModel = viewModel { RefundPolicyViewModel() }
) {

    val navController = LocalRootNavHostController.current
    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()

    RefundPolicyView(state) { event -> viewModel.obtainEvent(event) }

    when (action) {
        OpenPreviousScreen -> navController.popBackStack()
        OpenPrivacyPolicy -> navController.navigateWithClearAction(Privacy.name, viewModel::clearAction)
        OpenTermsOfService -> navController.navigateWithClearAction(TermsOfService.name, viewModel::clearAction)
        null -> {
            /* Do nothing*/
        }
    }
}
