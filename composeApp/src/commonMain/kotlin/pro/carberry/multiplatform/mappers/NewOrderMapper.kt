package pro.carberry.multiplatform.mappers

import pro.carberry.multiplatform.core.compose.dropmenu.models.DropItemModel
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupModel
import pro.carberry.multiplatform.repositories.neworder.models.NewOrderGroupInfoModel
import pro.carberry.multiplatform.repositories.neworder.models.NewOrderGroupInfoModel.NewOrderInfoModel
import pro.carberry.multiplatform.store.NewOrderModel

fun NewOrderGroupInfoModel.toDropMenuGroupModel(): DropMenuGroupModel {
    return DropMenuGroupModel(
        type = this.groupType,
        items = this.items.map { it.toDropItemModel() },
        selectedItem = this.selectedItem?.toDropItemModel(),
    )
}

fun NewOrderInfoModel.toDropItemModel(): DropItemModel {
    return DropItemModel(id = this.id, name = this.title)
}

fun List<NewOrderGroupInfoModel>.toNewOrderModel(): NewOrderModel = NewOrderModel(mainIfo = this)
