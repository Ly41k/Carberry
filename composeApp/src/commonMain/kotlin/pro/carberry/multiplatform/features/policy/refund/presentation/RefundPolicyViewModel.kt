package pro.carberry.multiplatform.features.policy.refund.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pro.carberry.multiplatform.core.di.Inject
import pro.carberry.multiplatform.core.exceptions.ExceptionService
import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.core.utils.Constants
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction.OpenPreviousScreen
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction.OpenPrivacyPolicy
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyAction.OpenTermsOfService
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyEvent
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyEvent.BackClick
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyEvent.PrivacyPolicyClick
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyEvent.TermsOfServiceClick
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyViewState
import pro.carberry.multiplatform.interactors.policy.PolicyInteractor

class RefundPolicyViewModel(
    private val policyInteractor: PolicyInteractor = Inject.instance(),
    private val exceptionService: ExceptionService = Inject.instance(),
    private val defaultDispatcher: CoroutineDispatcher = Inject.instance(Constants.DEFAULT_DISPATCHER_QUALIFIER)
) : BaseViewModel<RefundPolicyViewState, RefundPolicyAction, RefundPolicyEvent>(
    initialState = RefundPolicyViewState()
) {

    init {
        obtainRefundPolicy()
    }

    private fun obtainRefundPolicy() {
        policyInteractor.getRefundPolicy()
            .onEach { viewState = viewState.copy(policy = it) }
            .catch { exceptionService.logException(it) }
            .flowOn(defaultDispatcher)
            .launchIn(viewModelScope)
    }

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
