package pro.carberry.multiplatform.features.neworder.maininfo.presentation.models

import pro.carberry.multiplatform.core.compose.dropmenu.models.DropMenuGroupModel

data class OrderMainInfoViewState(
    val groups: List<DropMenuGroupModel> = emptyList()
)
