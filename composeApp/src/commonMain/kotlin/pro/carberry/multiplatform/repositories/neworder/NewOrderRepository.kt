package pro.carberry.multiplatform.repositories.neworder

import pro.carberry.multiplatform.repositories.neworder.models.NewOrderGroupInfoModel

interface NewOrderRepository {
    suspend fun getMainInfoByDefault(): List<NewOrderGroupInfoModel>
    suspend fun getNewOrderManufacturerById(vehicleTypeId: Long): NewOrderGroupInfoModel
    suspend fun getNewOrderModelByIds(vehicleTypeId: Long, manufacturerId: Long): NewOrderGroupInfoModel
    suspend fun getNewOrderEngineById(modelId: Long): NewOrderGroupInfoModel
    suspend fun getNewOrderECUTypeById(engineId: Long): NewOrderGroupInfoModel
}
