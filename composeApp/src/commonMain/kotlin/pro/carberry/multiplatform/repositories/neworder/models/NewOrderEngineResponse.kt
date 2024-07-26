package pro.carberry.multiplatform.repositories.neworder.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewOrderEngineResponse(
    @SerialName("engine_id") val engineId: Long,
    @SerialName("engine_name") val engineName: String
)

@Serializable
data class MockNewOrderEngineResponse(
    @SerialName("engine_id") val engineId: Long?,
    @SerialName("model_id") val modelId: Long?,
    @SerialName("engine_name") val engineName: String?
)

fun MockNewOrderEngineResponse.toNewOrderEngineResponse(): NewOrderEngineResponse? {
    return if (engineId == null || engineName == null) return null
    else NewOrderEngineResponse(engineId, engineName)
}
