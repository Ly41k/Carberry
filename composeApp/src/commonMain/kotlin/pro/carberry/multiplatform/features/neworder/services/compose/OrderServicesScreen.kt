package pro.carberry.multiplatform.features.neworder.services.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.features.neworder.services.presentation.OrderServicesViewModel
import pro.carberry.multiplatform.features.neworder.services.presentation.models.OrderServicesAction.OpenOrderAdditionalInfoScreen
import pro.carberry.multiplatform.features.neworder.services.presentation.models.OrderServicesAction.PopUp

@Composable
fun OrderServicesScreen(
    viewModel: OrderServicesViewModel = viewModel { OrderServicesViewModel() },
) {

    val navController = LocalRootNavHostController.current
    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()
    OrderServicesView(state) { event -> viewModel.obtainEvent(event) }

    when (action) {
        is OpenOrderAdditionalInfoScreen -> {}
        PopUp -> navController.popBackStack()
        null -> {
            /* Do nothing*/
        }
    }
}
