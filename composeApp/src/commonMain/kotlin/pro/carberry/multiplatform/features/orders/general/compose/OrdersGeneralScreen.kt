package pro.carberry.multiplatform.features.orders.general.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateWithClearAction
import pro.carberry.multiplatform.features.orders.general.presentation.OrdersGeneralViewModel
import pro.carberry.multiplatform.features.orders.general.presentation.models.OrdersGeneralAction.OpenNewOrderScreen
import pro.carberry.multiplatform.navigation.NewOrderAppScreens.MainInfo

@Composable
fun OrdersGeneralScreen(
    viewModel: OrdersGeneralViewModel = viewModel { OrdersGeneralViewModel() }
) {

    val navController = LocalRootNavHostController.current
    val action by viewModel.viewActions().observeAsState()

    OrdersGeneralView { event -> viewModel.obtainEvent(event) }

    when (action) {
        OpenNewOrderScreen -> navController.navigateWithClearAction(MainInfo.name, viewModel::clearAction)
        null -> {
            /* Do nothing*/
        }
    }
}
