package pro.carberry.multiplatform.datasource.neworder.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewOrderManufacturerResponse(
    @SerialName("manufacturer_id") val manufacturerId: Long,
    @SerialName("manufacturer_name") val manufacturerName: String
)

@Serializable
data class MockNewOrderManufacturerResponse(
    @SerialName("manufacturer_id") val manufacturerId: Long?,
    @SerialName("vehicle_type_ids") val vehicleTypeIds: List<VehicleType?>?,
    @SerialName("manufacturer_name") val manufacturerName: String?
) {
    @Serializable
    data class VehicleType(@SerialName("vehicle_type_id") val vehicleTypeId: Long?)
}

fun MockNewOrderManufacturerResponse.toNewOrderManufacturerResponse(): NewOrderManufacturerResponse? {
    return if (manufacturerId == null || manufacturerName == null) null
    else NewOrderManufacturerResponse(manufacturerId, manufacturerName)
}
