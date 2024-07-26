package pro.carberry.multiplatform.repositories.neworder.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewOrderModelResponse(
    @SerialName("model_id") val modelId: Long,
    @SerialName("model_name") val modelName: String
)

@Serializable
data class MockNewOrderModelResponse(
    @SerialName("model_id") val modelId: Long?,
    @SerialName("vehicle_type_id") val vehicleTypeId: Long?,
    @SerialName("manufacturer_id") val manufacturerId: Long?,
    @SerialName("model_name") val modelName: String?
)

fun MockNewOrderModelResponse.toNewOrderModelResponse(): NewOrderModelResponse? {
    return if (modelId == null || modelName == null) return null
    else NewOrderModelResponse(modelId, modelName)
}
