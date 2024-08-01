package pro.carberry.multiplatform.repositories.neworder.models

import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderECUTypeResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderEngineResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderManufacturerResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderModelResponse
import pro.carberry.multiplatform.datasource.neworder.models.NewOrderVehicleTypeResponse
import pro.carberry.multiplatform.repositories.neworder.models.NewOrderGroupInfoModel.NewOrderInfoModel

data class NewOrderGroupInfoModel(
    val groupType: DropMenuGroupType,
    val items: List<NewOrderInfoModel>,
    val selectedItem: NewOrderInfoModel? = if (items.size == 1) items.firstOrNull() else null
) {
    data class NewOrderInfoModel(val id: Long, val title: String)
}

fun NewOrderVehicleTypeResponse.toNewOrderInfoModel(): NewOrderInfoModel {
    return NewOrderInfoModel(vehicleTypeId, vehicleTypeName)
}

fun NewOrderManufacturerResponse.toNewOrderInfoModel(): NewOrderInfoModel {
    return NewOrderInfoModel(manufacturerId, manufacturerName)
}

fun NewOrderModelResponse.toNewOrderInfoModel(): NewOrderInfoModel {
    return NewOrderInfoModel(modelId, modelName)
}

fun NewOrderEngineResponse.toNewOrderInfoModel(): NewOrderInfoModel {
    return NewOrderInfoModel(engineId, engineName)
}

fun NewOrderECUTypeResponse.toNewOrderInfoModel(): NewOrderInfoModel {
    return NewOrderInfoModel(ecuTypeId, ecuTypeName)
}
