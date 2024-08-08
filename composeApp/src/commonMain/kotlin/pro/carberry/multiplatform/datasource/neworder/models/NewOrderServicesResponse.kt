package pro.carberry.multiplatform.datasource.neworder.models

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import pro.carberry.multiplatform.core.utils.serializers.BigDecimalSerializer

@Serializable
data class NewOrderServicesResponse(
    @SerialName("service_id") val serviceId: Long,
    @SerialName("service_type") val serviceType: String,
    @SerialName("service_name") val serviceName: String,
    @Serializable(with = BigDecimalSerializer::class)
    @SerialName("service_amount") val serviceAmount: BigDecimal,
    @SerialName("service_icon_url") val serviceIconUrl: String?,
    @SerialName("service_extra_info") val serviceExtraInfo: String?
)

@Serializable
data class MockNewOrderServicesResponse(
    @SerialName("service_id") val serviceId: Long?,
    @SerialName("ecu_type_ids") val ecuTypeIds: List<ECUType?>?,
    @SerialName("service_type") val serviceType: String?,
    @SerialName("service_name") val serviceName: String?,
    @Serializable(with = BigDecimalSerializer::class)
    @SerialName("service_amount") val serviceAmount: BigDecimal?,
    @SerialName("service_icon_url") val serviceIconUrl: String?,
    @SerialName("service_extra_info") val serviceExtraInfo: String?
) {
    @Serializable
    data class ECUType(@SerialName("ecu_type_id") val ecuTypeId: Long?)
}

fun MockNewOrderServicesResponse.toNewOrderServicesResponse(): NewOrderServicesResponse? {
    return if (serviceId == null || serviceName == null || serviceAmount == null) null
    else NewOrderServicesResponse(
        serviceId,
        serviceType.orEmpty(),
        serviceName,
        serviceAmount,
        serviceIconUrl,
        serviceExtraInfo
    )
}
