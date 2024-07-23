package pro.carberry.multiplatform.features.neworder.maininfo.presentation

import androidx.compose.ui.geometry.Size
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropItemModel
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupModel
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType
import pro.carberry.multiplatform.core.compose.dropmenu.models.OrderScreenType
import pro.carberry.multiplatform.core.presentation.BaseViewModel
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

class OrderMainInfoViewModel : BaseViewModel<OrderMainInfoViewState, OrderMainInfoAction, OrderMainInfoEvent>(
    initialState = OrderMainInfoViewState(groups = getMockDropMenuGroupModel())
) {

    override fun obtainEvent(viewEvent: OrderMainInfoEvent) {
        when (viewEvent) {
            is DropMenuExpanded -> onDropMenuExpanded(viewEvent.type)
            is SelectedTypeChanged -> onSelectedTypeChanged(viewEvent.type, viewEvent.value)
            is TextFieldSizeChanged -> onTextFieldSizeChanged(viewEvent.type, viewEvent.value)
            ContinueClick -> openNextScreen()
            BackClick -> openPreviousScreen()
        }
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

    private fun onSelectedTypeChanged(type: DropMenuGroupType, value: String) {
        viewState = viewState.copy(groups = viewState.groups.map { groupModel ->
            if (type == groupModel.type)
                groupModel.copy(selectedItem = groupModel.items.firstOrNull { it.name == value })
            else groupModel
        })
    }

    private fun onTextFieldSizeChanged(type: DropMenuGroupType, size: Size) {
        viewState = viewState.copy(groups = viewState.groups.map { groupModel ->
            if (type == groupModel.type) groupModel.copy(textFieldSize = size) else groupModel
        })
    }
}

private fun getMockDropMenuGroupModel(): List<DropMenuGroupModel> {
    return buildList {
        addAll(DropMenuGroupType.entries.toTypedArray().filter { it.type == OrderScreenType.MainInfo }
            .map { groupType ->
                DropMenuGroupModel(
                    type = groupType,
                    items = buildList { repeat(20) { add(DropItemModel(it.toLong(), "Item$it")) } },
                )
            })
    }
}
