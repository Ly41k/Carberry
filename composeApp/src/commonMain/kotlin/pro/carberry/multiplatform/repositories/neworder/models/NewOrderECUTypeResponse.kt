package pro.carberry.multiplatform.repositories.neworder.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewOrderECUTypeResponse(
    @SerialName("ecu_type_id") val ecuTypeId: Long,
    @SerialName("ecu_type_name") val ecuTypeName: String
)

@Serializable
data class MockNewOrderECUTypeResponse(
    @SerialName("ecu_type_id") val ecuTypeId: Long?,
    @SerialName("engine_id") val engineId: Long?,
    @SerialName("ecu_type_name") val ecuTypeName: String?
)

fun MockNewOrderECUTypeResponse.toNewOrderECUTypeResponse(): NewOrderECUTypeResponse? {
    return if (ecuTypeId == null || ecuTypeName == null) return null
    else NewOrderECUTypeResponse(ecuTypeId, ecuTypeName)
}
