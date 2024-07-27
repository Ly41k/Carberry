package pro.carberry.multiplatform.repositories.neworder

import pro.carberry.multiplatform.repositories.neworder.models.NewOrderGroupInfoModel

interface NewOrderRepository {
    suspend fun getNewOrderMainInformation(
        vehicleTypeId: Long? = null,
        manufacturerId: Long? = null,
        modelId: Long? = null,
        engineId: Long? = null
    ): List<NewOrderGroupInfoModel>
}
