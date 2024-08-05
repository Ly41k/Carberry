package pro.carberry.multiplatform.features.neworder.maininfo.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateWithClearAction
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.OrderMainInfoViewModel
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoAction.OpenOrderServicesScreen
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoAction.OpenPreviousScreen
import pro.carberry.multiplatform.navigation.NewOrderAppScreens.Services

@Composable
fun OrderMainInfoScreen(
    viewModel: OrderMainInfoViewModel = viewModel { OrderMainInfoViewModel() },
) {

    val navController = LocalRootNavHostController.current
    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()
    OrderMainInfoView(state) { event -> viewModel.obtainEvent(event) }

    when (action) {
        is OpenOrderServicesScreen -> navController.navigateWithClearAction(Services.name) { viewModel.clearAction() }
        OpenPreviousScreen -> navController.popBackStack()
        null -> {
            /* Do nothing*/
        }
    }
}
