package pro.carberry.multiplatform.features.neworder.maininfo.presentation.models

sealed interface OrderMainInfoAction {
    data class OpenOrderServicesScreen(val value: Any) : OrderMainInfoAction
    data object OpenPreviousScreen : OrderMainInfoAction
}
