package pro.carberry.multiplatform.features.neworder.maininfo.presentation

import androidx.compose.ui.geometry.Size
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropItemModel
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType
import pro.carberry.multiplatform.core.di.Inject
import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.core.store.ClearableBaseStore
import pro.carberry.multiplatform.core.utils.Constants.DEFAULT_DISPATCHER_QUALIFIER
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoAction
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoAction.OpenOrderServicesScreen
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoAction.OpenPreviousScreen
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent.BackClick
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent.ContinueClick
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent.DropMenuExpanded
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent.SelectedTypeChanged
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent.TextFieldSizeChanged
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoViewState
import pro.carberry.multiplatform.interactors.neworder.MainInfoInteractor
import pro.carberry.multiplatform.mappers.toDropItemModel
import pro.carberry.multiplatform.mappers.toDropMenuGroupModel
import pro.carberry.multiplatform.store.NewOrderModel

class OrderMainInfoViewModel(
    private val newOrderStore: ClearableBaseStore<NewOrderModel> = Inject.instance(),
    private val mainInfoInteractor: MainInfoInteractor = Inject.instance(),
    private val defaultDispatcher: CoroutineDispatcher = Inject.instance(DEFAULT_DISPATCHER_QUALIFIER)
) : BaseViewModel<OrderMainInfoViewState, OrderMainInfoAction, OrderMainInfoEvent>(
    initialState = OrderMainInfoViewState()
) {

    init {
        observeNewOrderStore()
    }

    override fun obtainEvent(viewEvent: OrderMainInfoEvent) {
        when (viewEvent) {
            is DropMenuExpanded -> onDropMenuExpanded(viewEvent.type)
            is SelectedTypeChanged -> onSelectedTypeChanged(viewEvent.type, viewEvent.item)
            is TextFieldSizeChanged -> onTextFieldSizeChanged(viewEvent.type, viewEvent.value)
            ContinueClick -> openNextScreen()
            BackClick -> openPreviousScreen()
        }
    }


    private fun observeNewOrderStore() {
        newOrderStore.observe()
            .onStart { mainInfoInteractor.initNewOrder() }
            .distinctUntilChanged()
            .map { it.mainIfo }
            .onEach { mainIfo ->
                mainIfo.map { newOrder ->
                    val type = viewState.groups.firstOrNull { it.type == newOrder.groupType }
                    viewState = when {
                        type == null -> {
                            viewState.copy(groups = buildList {
                                addAll(viewState.groups)
                                add(newOrder.toDropMenuGroupModel())
                            })
                        }

                        else -> {
                            viewState.copy(
                                groups = viewState.groups.map { groupModel ->
                                    if (type.type == groupModel.type)
                                        groupModel.copy(
                                            items = newOrder.items.map { it.toDropItemModel() },
                                            selectedItem = newOrder.selectedItem?.toDropItemModel()
                                        )
                                    else groupModel
                                }
                            )
                        }
                    }
                }
            }
            .flowOn(defaultDispatcher)
            .launchIn(viewModelScope)
    }

    private fun openPreviousScreen() {
        viewAction = OpenPreviousScreen
    }

    private fun openNextScreen() {
        viewAction = OpenOrderServicesScreen("")
    }

    private fun onDropMenuExpanded(type: DropMenuGroupType) {
        viewState = viewState.copy(groups = viewState.groups.map { groupModel ->
            if (type == groupModel.type) groupModel.copy(isDropMenuExpanded = !groupModel.isDropMenuExpanded)
            else groupModel
        })
    }

    private fun onSelectedTypeChanged(type: DropMenuGroupType, item: DropItemModel) {
        viewModelScope.launch { mainInfoInteractor.updateNewOrderByType(type, item) }
    }

    private fun onTextFieldSizeChanged(type: DropMenuGroupType, size: Size) {
        viewState = viewState.copy(groups = viewState.groups.map { groupModel ->
            if (type == groupModel.type) groupModel.copy(textFieldSize = size) else groupModel
        })
    }
}
