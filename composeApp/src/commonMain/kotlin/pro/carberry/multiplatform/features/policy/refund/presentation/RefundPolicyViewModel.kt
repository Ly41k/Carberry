package pro.carberry.multiplatform.features.policy.refund.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction.OpenPreviousScreen
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction.OpenPrivacyPolicy
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction.OpenTermsOfService
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyEvent
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyEvent.BackClick
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyEvent.PrivacyPolicyClick
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyEvent.TermsOfServiceClick

class RefundPolicyViewModel : BaseViewModel<Unit, RefundPolicyAction, RefundPolicyEvent>(initialState = Unit) {
    override fun obtainEvent(viewEvent: RefundPolicyEvent) {
        when (viewEvent) {
            BackClick -> openPreviousScreen()
            PrivacyPolicyClick -> openPrivacyPolicy()
            TermsOfServiceClick -> openTermsOfService()
        }
    }

    private fun openPreviousScreen() {
        viewAction = OpenPreviousScreen
    }

    private fun openPrivacyPolicy() {
        viewAction = OpenPrivacyPolicy
    }

    private fun openTermsOfService() {
        viewAction = OpenTermsOfService
    }
}
