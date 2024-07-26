package pro.carberry.multiplatform.repositories.neworder.data

import pro.carberry.multiplatform.repositories.neworder.models.VehicleTypeResponse

interface MainInfoDataSource {
    suspend fun getVehicleTypes(): List<VehicleTypeResponse>
}
