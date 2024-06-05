package pro.carberry.multiplatform.features.policy.refund.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction

class RefundPolicyViewModel : BaseViewModel<Unit, RefundPolicyAction, RefundPolicyAction>(initialState = Unit) {
    override fun obtainEvent(viewEvent: RefundPolicyAction) {
        TODO("Not yet implemented")
    }
}
