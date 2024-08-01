package pro.carberry.multiplatform.store

import pro.carberry.multiplatform.core.store.ClearableBaseStore
import pro.carberry.multiplatform.repositories.neworder.models.NewOrderGroupInfoModel

class NewOrderStore : ClearableBaseStore<NewOrderModel>(
    getClearValue = { NewOrderModel() },
    getInitialValue = { NewOrderModel() }
)

data class NewOrderModel(
    val mainIfo: List<NewOrderGroupInfoModel> = emptyList()
)
