package pro.carberry.multiplatform.repositories.neworder

import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType.ECUType
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType.Engine
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType.Manufacturer
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType.Model
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType.VehicleType
import pro.carberry.multiplatform.datasource.neworder.MainInfoDataSource
import pro.carberry.multiplatform.repositories.neworder.models.NewOrderGroupInfoModel
import pro.carberry.multiplatform.repositories.neworder.models.toNewOrderInfoModel

class NewOrderRepositoryImpl(
    private val mainInfoDataSource: MainInfoDataSource
) : NewOrderRepository {

    override suspend fun getNewOrderMainInformation(
        vehicleTypeId: Long?,
        manufacturerId: Long?,
        modelId: Long?,
        engineId: Long?
    ): List<NewOrderGroupInfoModel> {
        return buildList {
            add(getNewOrderVehicleTypesGroup())
            add(getNewOrderManufacturerGroup(manufacturerId))
            add(getNewOrderModels(vehicleTypeId, manufacturerId))
            add(getNewOrderEngines(modelId))
            add(getNewOrderECUType(engineId))
        }
    }

    private suspend fun getNewOrderVehicleTypesGroup(): NewOrderGroupInfoModel {
        return NewOrderGroupInfoModel(
            groupType = VehicleType,
            items = mainInfoDataSource.fetchVehicleTypes().map { it.toNewOrderInfoModel() }
        )
    }

    private suspend fun getNewOrderManufacturerGroup(vehicleTypeId: Long?): NewOrderGroupInfoModel {
        return NewOrderGroupInfoModel(
            groupType = Manufacturer,
            items = mainInfoDataSource.fetchManufacturers(vehicleTypeId).map { it.toNewOrderInfoModel() }
        )
    }

    private suspend fun getNewOrderModels(vehicleTypeId: Long?, manufacturerId: Long?): NewOrderGroupInfoModel {
        return NewOrderGroupInfoModel(
            groupType = Model,
            items = mainInfoDataSource.fetchModels(vehicleTypeId, manufacturerId).map { it.toNewOrderInfoModel() }
        )
    }

    private suspend fun getNewOrderEngines(modelId: Long?): NewOrderGroupInfoModel {
        return NewOrderGroupInfoModel(
            groupType = Engine,
            mainInfoDataSource.fetchEngines(modelId).map { it.toNewOrderInfoModel() }
        )
    }

    private suspend fun getNewOrderECUType(engineId: Long?): NewOrderGroupInfoModel {
        return NewOrderGroupInfoModel(
            groupType = ECUType,
            items = mainInfoDataSource.fetchECUType(engineId).map { it.toNewOrderInfoModel() }
        )
    }
}
