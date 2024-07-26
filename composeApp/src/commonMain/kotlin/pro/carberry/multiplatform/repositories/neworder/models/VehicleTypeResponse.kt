package pro.carberry.multiplatform.repositories.neworder.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VehicleTypeResponse(
    @SerialName("vehicle_type_id") val vehicleTypeId: Long,
    @SerialName("vehicle_type_name") val vehicleTypeName: String
)

@Serializable
data class MockVehicleTypeResponse(
    @SerialName("vehicle_type_id") val vehicleTypeId: Long? = null,
    @SerialName("vehicle_type_name") val vehicleTypeName: String? = null
)

fun MockVehicleTypeResponse.toVehicleTypeResponse(): VehicleTypeResponse? {
    return if (vehicleTypeId == null || vehicleTypeName == null) return null
    else VehicleTypeResponse(vehicleTypeId, vehicleTypeName)
}
