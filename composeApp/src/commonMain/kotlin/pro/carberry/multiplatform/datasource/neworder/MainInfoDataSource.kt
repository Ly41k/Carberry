package pro.carberry.multiplatform.datasource.neworder

import pro.carberry.multiplatform.datasource.neworder.models.NewOrderECUTypeResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderEngineResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderManufacturerResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderModelResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderVehicleTypeResponse

interface MainInfoDataSource {
    suspend fun fetchVehicleTypes(): List<NewOrderVehicleTypeResponse>
    suspend fun fetchManufacturers(vehicleTypeId: Long?): List<NewOrderManufacturerResponse>
    suspend fun fetchModels(vehicleTypeId: Long?, manufacturerId: Long?): List<NewOrderModelResponse>
    suspend fun fetchEngines(modelId: Long?): List<NewOrderEngineResponse>
    suspend fun fetchECUType(engineId: Long?): List<NewOrderECUTypeResponse>
}
