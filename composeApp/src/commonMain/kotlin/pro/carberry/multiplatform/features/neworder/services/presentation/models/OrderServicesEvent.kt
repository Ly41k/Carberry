package pro.carberry.multiplatform.features.neworder.services.presentation.models

sealed class OrderServicesEvent {
    data object ContinueClick : OrderServicesEvent()
    data object BackClick : OrderServicesEvent()
    data class ServiceStateChanged(val id: Long) : OrderServicesEvent()
}
