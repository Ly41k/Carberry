package pro.carberry.multiplatform.datasource.neworder.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewOrderVehicleTypeResponse(
    @SerialName("vehicle_type_id") val vehicleTypeId: Long,
    @SerialName("vehicle_type_name") val vehicleTypeName: String
)

@Serializable
data class MockNewOrderVehicleTypeResponse(
    @SerialName("vehicle_type_id") val vehicleTypeId: Long? = null,
    @SerialName("vehicle_type_name") val vehicleTypeName: String? = null
)

fun MockNewOrderVehicleTypeResponse.toNewOrderVehicleTypeResponse(): NewOrderVehicleTypeResponse? {
    return if (vehicleTypeId == null || vehicleTypeName == null) null
    else NewOrderVehicleTypeResponse(vehicleTypeId, vehicleTypeName)
}
