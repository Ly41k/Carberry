package pro.carberry.multiplatform.features.orders.general.presentation.models

sealed interface OrdersGeneralEvent {
    data object NewOrderClick : OrdersGeneralEvent
}
