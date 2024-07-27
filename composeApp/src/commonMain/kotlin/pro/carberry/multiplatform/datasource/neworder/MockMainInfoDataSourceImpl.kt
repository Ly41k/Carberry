package pro.carberry.multiplatform.datasource.neworder

import carberry.composeapp.generated.resources.Res
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.MissingResourceException
import pro.carberry.multiplatform.core.exceptions.ExceptionService
import pro.carberry.multiplatform.core.utils.Constants.ECU_TYPE_MOCK_PATH
import pro.carberry.multiplatform.core.utils.Constants.ENGINE_MOCK_PATH
import pro.carberry.multiplatform.core.utils.Constants.MANUFACTURER_MOCK_PATH
import pro.carberry.multiplatform.core.utils.Constants.MODEL_MOCK_PATH
import pro.carberry.multiplatform.core.utils.Constants.VEHICLE_TYPE_MOCK_PATH
import pro.carberry.multiplatform.datasource.neworder.models.MockNewOrderECUTypeResponse
import pro.carberry.multiplatform.datasource.neworder.models.MockNewOrderEngineResponse
import pro.carberry.multiplatform.datasource.neworder.models.MockNewOrderManufacturerResponse
import pro.carberry.multiplatform.datasource.neworder.models.MockNewOrderModelResponse
import pro.carberry.multiplatform.datasource.neworder.models.MockNewOrderVehicleTypeResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderECUTypeResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderEngineResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderManufacturerResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderModelResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderVehicleTypeResponse
import pro.carberry.multiplatform.datasource.neworder.models.toNewOrderECUTypeResponse
import pro.carberry.multiplatform.datasource.neworder.models.toNewOrderEngineResponse
import pro.carberry.multiplatform.datasource.neworder.models.toNewOrderManufacturerResponse
import pro.carberry.multiplatform.datasource.neworder.models.toNewOrderModelResponse
import pro.carberry.multiplatform.datasource.neworder.models.toNewOrderVehicleTypeResponse

class MockMainInfoDataSourceImpl(
    private val json: Json,
    private val ioDispatcher: CoroutineDispatcher,
    private val exceptionService: ExceptionService
) : MainInfoDataSource {

    override suspend fun fetchVehicleTypes(): List<NewOrderVehicleTypeResponse> {
        return withContext(ioDispatcher) {
            try {
                val byteArray = Res.readBytes(VEHICLE_TYPE_MOCK_PATH)
                val jsonString = byteArray.decodeToString()
                return@withContext json.decodeFromString<List<MockNewOrderVehicleTypeResponse>>(jsonString)
                    .mapNotNull { it.toNewOrderVehicleTypeResponse() }
            } catch (e: MissingResourceException) {
                exceptionService.logException(e)
                return@withContext emptyList()
            }
        }
    }

    override suspend fun fetchManufacturers(vehicleTypeId: Long?): List<NewOrderManufacturerResponse> {
        if (vehicleTypeId == null) return emptyList()
        return withContext(ioDispatcher) {
            try {
                val byteArray = Res.readBytes(MANUFACTURER_MOCK_PATH)
                val jsonString = byteArray.decodeToString()
                return@withContext json.decodeFromString<List<MockNewOrderManufacturerResponse>>(jsonString)
                    .filter { manufacturerResponse ->
                        manufacturerResponse.vehicleTypeIds?.filter { it?.vehicleTypeId == vehicleTypeId }
                            .orEmpty()
                            .isNotEmpty()
                    }
                    .mapNotNull { it.toNewOrderManufacturerResponse() }
            } catch (e: MissingResourceException) {
                exceptionService.logException(e)
                return@withContext emptyList()
            }
        }
    }

    override suspend fun fetchModels(vehicleTypeId: Long?, manufacturerId: Long?): List<NewOrderModelResponse> {
        if (manufacturerId == null || vehicleTypeId == null) return emptyList()
        return withContext(ioDispatcher) {
            try {
                val byteArray = Res.readBytes(MODEL_MOCK_PATH)
                val jsonString = byteArray.decodeToString()
                return@withContext json.decodeFromString<List<MockNewOrderModelResponse>>(jsonString)
                    .filter { modelResponse ->
                        modelResponse.manufacturerId == manufacturerId && modelResponse.vehicleTypeId == vehicleTypeId
                    }
                    .mapNotNull { it.toNewOrderModelResponse() }
            } catch (e: MissingResourceException) {
                exceptionService.logException(e)
                return@withContext emptyList()
            }
        }
    }

    override suspend fun fetchEngines(modelId: Long?): List<NewOrderEngineResponse> {
        if (modelId == null) return emptyList()
        return withContext(ioDispatcher) {
            try {
                val byteArray = Res.readBytes(ENGINE_MOCK_PATH)
                val jsonString = byteArray.decodeToString()
                return@withContext json.decodeFromString<List<MockNewOrderEngineResponse>>(jsonString)
                    .filter { modelResponse -> modelResponse.modelId == modelId }
                    .mapNotNull { it.toNewOrderEngineResponse() }
            } catch (e: MissingResourceException) {
                exceptionService.logException(e)
                return@withContext emptyList()
            }
        }
    }

    override suspend fun fetchECUType(engineId: Long?): List<NewOrderECUTypeResponse> {
        if (engineId == null) return emptyList()
        return withContext(ioDispatcher) {
            try {
                val byteArray = Res.readBytes(ECU_TYPE_MOCK_PATH)
                val jsonString = byteArray.decodeToString()
                return@withContext json.decodeFromString<List<MockNewOrderECUTypeResponse>>(jsonString)
                    .filter { modelResponse -> modelResponse.engineId == engineId }
                    .mapNotNull { it.toNewOrderECUTypeResponse() }
            } catch (e: MissingResourceException) {
                exceptionService.logException(e)
                return@withContext emptyList()
            }
        }
    }
}
