package pro.carberry.multiplatform.interactors.neworder

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.carberry.multiplatform.core.store.ClearableBaseStore
import pro.carberry.multiplatform.repositories.neworder.NewOrderRepository
import pro.carberry.multiplatform.repositories.neworder.models.NewOrderGroupInfoModel
import pro.carberry.multiplatform.store.NewOrderModel

interface MainInfoInteractor {

    suspend fun initNewOrder()

    fun updateMainInfo(
        vehicleTypeId: Long? = null,
        manufacturerId: Long? = null,
        modelId: Long? = null,
        engineId: Long? = null
    ): Flow<Boolean>
}

class MainInfoInteractorImpl(
    private val newOrderRepository: NewOrderRepository,
    private val newOrderStore: ClearableBaseStore<NewOrderModel>
) : MainInfoInteractor {
    override suspend fun initNewOrder() {
        val mainInfo = newOrderRepository.getNewOrderMainInformation()
        newOrderStore.publish(mainInfo.toNewOrderModel())
    }

    override fun updateMainInfo(
        vehicleTypeId: Long?,
        manufacturerId: Long?,
        modelId: Long?,
        engineId: Long?
    ): Flow<Boolean> {
        return flow {
            val mainInfo =
                newOrderRepository.getNewOrderMainInformation(vehicleTypeId, manufacturerId, modelId, engineId)
            emit(newOrderStore.publish(mainInfo.toNewOrderModel()))
        }
    }
}

fun List<NewOrderGroupInfoModel>.toNewOrderModel(): NewOrderModel = NewOrderModel(mainIfo = this)
