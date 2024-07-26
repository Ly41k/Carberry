package pro.carberry.multiplatform.repositories.neworder.data

import carberry.composeapp.generated.resources.Res
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.MissingResourceException
import pro.carberry.multiplatform.core.exceptions.ExceptionService
import pro.carberry.multiplatform.core.utils.Constants.VEHICLE_TYPE_MOCK_PATH
import pro.carberry.multiplatform.repositories.neworder.models.MockVehicleTypeResponse
import pro.carberry.multiplatform.repositories.neworder.models.VehicleTypeResponse
import pro.carberry.multiplatform.repositories.neworder.models.toVehicleTypeResponse

class MockMainInfoDataSourceImpl(
    private val json: Json,
    private val ioDispatcher: CoroutineDispatcher,
    private val exceptionService: ExceptionService
) : MainInfoDataSource {

    override suspend fun getVehicleTypes(): List<VehicleTypeResponse> {
        return withContext(ioDispatcher) {
            try {
                val byteArray = Res.readBytes(VEHICLE_TYPE_MOCK_PATH)
                val jsonString = byteArray.decodeToString()
                return@withContext json.decodeFromString<List<MockVehicleTypeResponse>>(jsonString)
                    .mapNotNull { it.toVehicleTypeResponse() }
            } catch (e: MissingResourceException) {
                exceptionService.logException(e)
                return@withContext emptyList()
            }
        }
    }
}
