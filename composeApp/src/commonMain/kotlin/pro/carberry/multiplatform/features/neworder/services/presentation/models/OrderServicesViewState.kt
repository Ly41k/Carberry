package pro.carberry.multiplatform.features.neworder.services.presentation.models

data class OrderServicesViewState(
    val services: List<OrderServiceModel> = emptyList(),
    val finalAmount: Long = 0,
)
