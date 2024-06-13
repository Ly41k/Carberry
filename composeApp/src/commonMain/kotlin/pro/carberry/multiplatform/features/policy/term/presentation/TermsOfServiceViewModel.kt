package pro.carberry.multiplatform.features.policy.term.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pro.carberry.multiplatform.core.di.Inject
import pro.carberry.multiplatform.core.exceptions.ExceptionService
import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.core.utils.Constants.DEFAULT_DISPATCHER_QUALIFIER
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction.OpenPreviousScreen
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction.OpenPrivacyPolicy
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceAction.OpenRefundPolicy
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceEvent
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceEvent.BackClick
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceEvent.PrivacyPolicyClick
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceEvent.RefundPolicyClick
import pro.carberry.multiplatform.features.policy.term.presentation.models.TermsOfServiceViewState
import pro.carberry.multiplatform.interactors.policy.PolicyInteractor

class TermsOfServiceViewModel(
    private val policyInteractor: PolicyInteractor = Inject.instance(),
    private val exceptionService: ExceptionService = Inject.instance(),
    private val defaultDispatcher: CoroutineDispatcher = Inject.instance(DEFAULT_DISPATCHER_QUALIFIER)
) : BaseViewModel<TermsOfServiceViewState, TermsOfServiceAction, TermsOfServiceEvent>(
    initialState = TermsOfServiceViewState()
) {

    init {
        obtainTermsOfService()
    }

    private fun obtainTermsOfService() {
        policyInteractor.getTermsOfService()
            .onEach { viewState = viewState.copy(policy = it) }
            .catch { exceptionService.logException(it) }
            .flowOn(defaultDispatcher)
            .launchIn(viewModelScope)
    }

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
