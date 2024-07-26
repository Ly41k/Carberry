package pro.carberry.multiplatform.repositories.neworder.data

import pro.carberry.multiplatform.repositories.neworder.models.NewOrderECUTypeResponse
import pro.carberry.multiplatform.repositories.neworder.models.NewOrderEngineResponse
import pro.carberry.multiplatform.repositories.neworder.models.NewOrderManufacturerResponse
import pro.carberry.multiplatform.repositories.neworder.models.NewOrderModelResponse
import pro.carberry.multiplatform.repositories.neworder.models.NewOrderVehicleTypeResponse

interface MainInfoDataSource {
    suspend fun fetchVehicleTypes(): List<NewOrderVehicleTypeResponse>
    suspend fun fetchManufacturers(vehicleTypeId: Long?): List<NewOrderManufacturerResponse>
    suspend fun fetchModels(vehicleTypeId: Long?, manufacturerId: Long?): List<NewOrderModelResponse>
    suspend fun fetchEngines(modelId: Long?): List<NewOrderEngineResponse>
    suspend fun fetchECUType(engineId: Long?): List<NewOrderECUTypeResponse>
}
