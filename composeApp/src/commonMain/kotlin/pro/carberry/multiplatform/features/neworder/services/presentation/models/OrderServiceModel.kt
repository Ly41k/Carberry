package pro.carberry.multiplatform.features.neworder.services.presentation.models

data class OrderServiceModel(
    val id: Long,
    val serviceName: String,
    val serviceAmount: Long, //TODO need to use BigDecimal
    val isServiceAdded: Boolean = false,
    val serviceIconUrl: String? = null, //TODO need to use AsyncImage by Coil
    val serviceExtraInfo: String
)
