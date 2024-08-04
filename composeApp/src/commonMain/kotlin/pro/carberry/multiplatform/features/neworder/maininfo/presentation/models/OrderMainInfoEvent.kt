package pro.carberry.multiplatform.features.neworder.maininfo.presentation.models

import androidx.compose.ui.geometry.Size
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropItemModel
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupType

sealed interface OrderMainInfoEvent {
    data class DropMenuExpanded(val type: DropMenuGroupType) : OrderMainInfoEvent
    data class SelectedTypeChanged(val type: DropMenuGroupType, val item: DropItemModel) : OrderMainInfoEvent
    data class TextFieldSizeChanged(val type: DropMenuGroupType, val value: Size) : OrderMainInfoEvent
    data object ContinueClick : OrderMainInfoEvent
    data object BackClick : OrderMainInfoEvent
}
