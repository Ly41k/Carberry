package pro.carberry.multiplatform.features.policy.privacy.presentation

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
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyAction
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyAction.OpenPreviousScreen
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyAction.OpenRefundPolicy
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyAction.OpenTermsOfService
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyEvent
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyEvent.BackClick
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyEvent.RefundPolicyClick
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyEvent.TermsOfServiceClick
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyViewState
import pro.carberry.multiplatform.interactors.policy.PolicyInteractor

class PrivacyPolicyViewModel(
    private val policyInteractor: PolicyInteractor = Inject.instance(),
    private val exceptionService: ExceptionService = Inject.instance(),
    private val defaultDispatcher: CoroutineDispatcher = Inject.instance(DEFAULT_DISPATCHER_QUALIFIER)
) : BaseViewModel<PrivacyPolicyViewState, PrivacyPolicyAction, PrivacyPolicyEvent>(
    initialState = PrivacyPolicyViewState()
) {

    init {
        obtainPrivacyPolicy()
    }

    private fun obtainPrivacyPolicy() {
        policyInteractor.getPrivacyPolicy()
            .onEach { viewState = viewState.copy(policy = it) }
            .catch { exceptionService.logException(it) }
            .flowOn(defaultDispatcher)
            .launchIn(viewModelScope)
    }

    override fun obtainEvent(viewEvent: PrivacyPolicyEvent) {
        when (viewEvent) {
            BackClick -> openPreviousScreen()
            TermsOfServiceClick -> openTermsOfService()
            RefundPolicyClick -> openRefundPolicy()
        }
    }

    private fun openPreviousScreen() {
        viewAction = OpenPreviousScreen
    }

    private fun openRefundPolicy() {
        viewAction = OpenRefundPolicy
    }

    private fun openTermsOfService() {
        viewAction = OpenTermsOfService
    }
}
