package pro.carberry.multiplatform.interactors.neworder

import pro.carberry.multiplatform.core.compose.dropmenu.models.DropItemModel
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType.ECUType
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType.Engine
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType.Manufacturer
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType.Model
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType.VehicleType
import pro.carberry.multiplatform.core.store.ClearableBaseStore
import pro.carberry.multiplatform.mappers.toNewOrderModel
import pro.carberry.multiplatform.repositories.neworder.NewOrderRepository
import pro.carberry.multiplatform.store.NewOrderModel

interface MainInfoInteractor {
    suspend fun initNewOrder()
    suspend fun updateNewOrderByType(type: DropMenuGroupType, item: DropItemModel)
}

class MainInfoInteractorImpl(
    private val newOrderRepository: NewOrderRepository,
    private val newOrderStore: ClearableBaseStore<NewOrderModel>
) : MainInfoInteractor {
    override suspend fun initNewOrder() {
        val mainInfo = newOrderRepository.getMainInfoByDefault()
        newOrderStore.publish(mainInfo.toNewOrderModel())
    }

    // TODO Need to migrate to Flow
    override suspend fun updateNewOrderByType(type: DropMenuGroupType, item: DropItemModel) {
        when (type) {
            VehicleType -> {
                val manufacturerGroupModel = newOrderRepository.getNewOrderManufacturerById(item.id)
                newOrderStore.update { prevState ->
                    prevState.copy(
                        mainIfo = prevState.mainIfo.map { model ->
                            when (model.groupType) {
                                VehicleType -> model.copy(selectedItem = model.items.firstOrNull { it.id == item.id })
                                Manufacturer -> model.copy(
                                    items = manufacturerGroupModel.items,
                                    selectedItem = manufacturerGroupModel.selectedItem
                                )

                                else -> model.copy(items = emptyList(), selectedItem = null)
                            }
                        }
                    )
                }
            }

            Manufacturer -> {
                val vehicleTypeId = getVehicleTypeId() ?: return
                val modelGroupModel = newOrderRepository.getNewOrderModelByIds(vehicleTypeId, item.id)
                newOrderStore.update { prevState ->
                    prevState.copy(
                        mainIfo = prevState.mainIfo.map { model ->
                            when (model.groupType) {
                                VehicleType -> model
                                Manufacturer -> model.copy(selectedItem = model.items.firstOrNull { it.id == item.id })
                                Model -> model.copy(
                                    items = modelGroupModel.items,
                                    selectedItem = modelGroupModel.selectedItem
                                )

                                else -> model.copy(items = emptyList(), selectedItem = null)
                            }
                        }
                    )
                }
            }

            Model -> {
                val engineGroupModel = newOrderRepository.getNewOrderEngineById(item.id)
                newOrderStore.update { prevState ->
                    prevState.copy(
                        mainIfo = prevState.mainIfo.map { model ->
                            when (model.groupType) {
                                VehicleType -> model
                                Manufacturer -> model
                                Model -> model.copy(selectedItem = model.items.firstOrNull { it.id == item.id })
                                Engine -> model.copy(
                                    items = engineGroupModel.items,
                                    selectedItem = engineGroupModel.selectedItem
                                )

                                else -> model.copy(items = emptyList(), selectedItem = null)
                            }
                        }
                    )
                }
            }

            Engine -> {
                val ecuTypeGroupModel = newOrderRepository.getNewOrderECUTypeById(item.id)
                newOrderStore.update { prevState ->
                    prevState.copy(
                        mainIfo = prevState.mainIfo.map { model ->
                            when (model.groupType) {
                                VehicleType,
                                Manufacturer,
                                Model -> model

                                Engine -> model.copy(selectedItem = model.items.firstOrNull { it.id == item.id })
                                ECUType -> model.copy(
                                    items = ecuTypeGroupModel.items,
                                    selectedItem = ecuTypeGroupModel.selectedItem
                                )

                                else -> model.copy(items = emptyList(), selectedItem = null)
                            }
                        }
                    )
                }
            }

            ECUType -> {
                newOrderStore.update { prevState ->
                    prevState.copy(
                        mainIfo = prevState.mainIfo.map { model ->
                            when (model.groupType) {
                                VehicleType,
                                Manufacturer,
                                Model, Engine -> model

                                ECUType -> model.copy(selectedItem = model.items.firstOrNull { it.id == item.id })

                                else -> model.copy(items = emptyList(), selectedItem = null)
                            }
                        }
                    )
                }
            }

            else -> {
                // Do nothing
            }
        }
    }

    private fun getVehicleTypeId(): Long? = newOrderStore.value.mainIfo.firstOrNull()?.selectedItem?.id

}
