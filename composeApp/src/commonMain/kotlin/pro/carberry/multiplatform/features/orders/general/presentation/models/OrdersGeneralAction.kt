package pro.carberry.multiplatform.features.orders.general.presentation.models

sealed interface OrdersGeneralAction {
    data object OpenNewOrderScreen : OrdersGeneralAction
}
