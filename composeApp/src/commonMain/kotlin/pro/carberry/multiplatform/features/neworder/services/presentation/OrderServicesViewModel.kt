package pro.carberry.multiplatform.features.neworder.services.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.neworder.services.presentation.models.OrderServiceModel
import pro.carberry.multiplatform.features.neworder.services.presentation.models.OrderServicesAction
import pro.carberry.multiplatform.features.neworder.services.presentation.models.OrderServicesEvent
import pro.carberry.multiplatform.features.neworder.services.presentation.models.OrderServicesViewState
import kotlin.random.Random
import kotlin.random.nextLong

class OrderServicesViewModel : BaseViewModel<OrderServicesViewState, OrderServicesAction, OrderServicesEvent>(
    initialState = getMockOrderServicesViewState()
) {
    override fun obtainEvent(viewEvent: OrderServicesEvent) {
        when (viewEvent) {
            OrderServicesEvent.BackClick -> onPopUp()
            OrderServicesEvent.ContinueClick -> openNextScreen()
            is OrderServicesEvent.ServiceStateChanged -> onServiceStateChanged(viewEvent.id)
        }
    }

    private fun onServiceStateChanged(serviceId: Long) {
        viewState = viewState.copy(
            services = viewState.services.map { service ->
                if (serviceId == service.id) service.copy(isServiceAdded = !service.isServiceAdded)
                else service
            }
        )
    }

    private fun onPopUp() {
        viewAction = OrderServicesAction.PopUp
    }

    private fun openNextScreen() {
        viewAction = OrderServicesAction.OpenOrderAdditionalInfoScreen("")
    }
}

private fun getMockOrderServicesViewState(): OrderServicesViewState {
    return OrderServicesViewState(services = getMockOrderServices())
}

private fun getMockOrderServices(): List<OrderServiceModel> {
    return buildList {
        repeat(10) {
            add(
                OrderServiceModel(
                    id = (it + 1).toLong(),
                    serviceName = "Pop&Bang/Hardcut/Popcorn (depending of model ECU)",
                    serviceAmount = Random.nextLong(95L..200L),
                    serviceExtraInfo = "Please remember that this function possible only if car have full decat, so you should also order full decat (or do it yourself) and remove CAT from exhaust. This option available not for all soft versions"
                )
            )
        }
    }
}