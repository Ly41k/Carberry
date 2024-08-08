package pro.carberry.multiplatform.datasource.neworder

import carberry.composeapp.generated.resources.Res
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.MissingResourceException
import pro.carberry.multiplatform.core.exceptions.ExceptionService
import pro.carberry.multiplatform.core.utils.Constants.SERVICES_MOCK_PATH
import pro.carberry.multiplatform.datasource.neworder.models.MockNewOrderServicesResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderServicesResponse
import pro.carberry.multiplatform.datasource.neworder.models.toNewOrderServicesResponse

class MockServicesDataSourceImpl(
    private val json: Json,
    private val ioDispatcher: CoroutineDispatcher,
    private val exceptionService: ExceptionService
) : ServicesDataSource {
    override suspend fun fetchServices(ecuTypeId: Long?): List<NewOrderServicesResponse> {
        if (ecuTypeId == null) return emptyList()
        return withContext(ioDispatcher) {
            try {
                val byteArray = Res.readBytes(SERVICES_MOCK_PATH)
                val jsonString = byteArray.decodeToString()
                return@withContext json.decodeFromString<List<MockNewOrderServicesResponse>>(jsonString)
                    .filter { servicesResponse ->
                        servicesResponse.ecuTypeIds?.filter { it?.ecuTypeId == ecuTypeId }
                            .orEmpty()
                            .isNotEmpty()
                    }
                    .mapNotNull { it.toNewOrderServicesResponse() }
            } catch (e: MissingResourceException) {
                exceptionService.logException(e)
                return@withContext emptyList()
            }
        }
    }
}
