package pro.carberry.multiplatform.features.policy.term.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateWithClearAction
import pro.carberry.multiplatform.features.policy.term.presentation.TermsOfServiceViewModel
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction.OpenPreviousScreen
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction.OpenPrivacyPolicy
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction.OpenRefundPolicy
import pro.carberry.multiplatform.navigation.PolicyAppScreens.Privacy
import pro.carberry.multiplatform.navigation.PolicyAppScreens.Refund

@Composable
fun TermsOfServiceScreen(viewModel: TermsOfServiceViewModel = viewModel { TermsOfServiceViewModel() }) {

    val navController = LocalRootNavHostController.current
    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()

    TermsOfServiceView(state) { event -> viewModel.obtainEvent(event) }

    when (action) {
        OpenPreviousScreen -> navController.popBackStack()
        OpenPrivacyPolicy -> navController.navigateWithClearAction(Privacy.name, viewModel::clearAction)
        OpenRefundPolicy -> navController.navigateWithClearAction(Refund.name, viewModel::clearAction)
        null -> {
            /* Do nothing*/
        }
    }
}
