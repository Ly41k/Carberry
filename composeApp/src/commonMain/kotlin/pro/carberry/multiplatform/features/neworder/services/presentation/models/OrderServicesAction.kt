package pro.carberry.multiplatform.features.neworder.services.presentation.models


sealed class OrderServicesAction {
    data class OpenOrderAdditionalInfoScreen(val value: Any) : OrderServicesAction()
    data object PopUp : OrderServicesAction()
}
