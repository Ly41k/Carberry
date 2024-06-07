package pro.carberry.multiplatform.features.policy.term.presentation

import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction.OpenPreviousScreen
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction.OpenPrivacyPolicy
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction.OpenRefundPolicy
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceEvent
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceEvent.BackClick
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceEvent.PrivacyPolicyClick
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceEvent.RefundPolicyClick

class TermsOfServiceViewModel : BaseViewModel<Unit, TermsOfServiceAction, TermsOfServiceEvent>(initialState = Unit) {
    override fun obtainEvent(viewEvent: TermsOfServiceEvent) {
        when (viewEvent) {
            BackClick -> openPreviousScreen()
            PrivacyPolicyClick -> openPrivacyPolicy()
            RefundPolicyClick -> openRefundPolicy()
        }
    }

    private fun openPreviousScreen() {
        viewAction = OpenPreviousScreen
    }

    private fun openRefundPolicy() {
        viewAction = OpenRefundPolicy
    }

    private fun openPrivacyPolicy() {
        viewAction = OpenPrivacyPolicy
    }
}
