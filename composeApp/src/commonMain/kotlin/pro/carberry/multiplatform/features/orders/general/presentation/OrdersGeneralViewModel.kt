package pro.carberry.multiplatform.features.orders.general.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.orders.general.presentation.models.OrdersGeneralAction
import pro.carberry.multiplatform.features.orders.general.presentation.models.OrdersGeneralEvent
import pro.carberry.multiplatform.features.orders.general.presentation.models.OrdersGeneralViewState

class OrdersGeneralViewModel : BaseViewModel<OrdersGeneralViewState, OrdersGeneralAction, OrdersGeneralEvent>(
    initialState = OrdersGeneralViewState()
) {
    override fun obtainEvent(viewEvent: OrdersGeneralEvent) {
        //TODO("Not yet implemented")
    }
}
