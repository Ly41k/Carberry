package pro.carberry.multiplatform.features.orders.general.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.features.orders.general.presentation.OrdersGeneralViewModel

@Composable
fun OrdersGeneralScreen(
    viewModel: OrdersGeneralViewModel = viewModel { OrdersGeneralViewModel() }
) {

    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()

    OrdersGeneralView { event -> viewModel.obtainEvent(event) }
}
