package pro.carberry.multiplatform.interactors.policy

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem
import pro.carberry.multiplatform.mappers.PolicyMapper
import pro.carberry.multiplatform.repositories.policy.PolicyRepository

class PolicyInteractorImpl(
    private val policyRepository: PolicyRepository,
    private val policyMapper: PolicyMapper
) : PolicyInteractor {
    override fun getTermsOfService(): Flow<List<PolicyViewItem>> {
        return flow { emit(policyRepository.getTermsOfServicePolicy()) }
            .map { it.map { model -> policyMapper.toTermsOfService(model) }.flatten() }
    }

    override fun getRefundPolicy(): Flow<List<PolicyViewItem>> {
        return flow { emit(policyRepository.getRefundPolicy()) }
            .map { it.map { model -> policyMapper.toRefundPolicy(model) }.flatten() }
    }

    override fun getPrivacyPolicy(): Flow<List<PolicyViewItem>> {
        return flow { emit(policyRepository.getPrivacyPolicy()) }
            .map { it.map { model -> policyMapper.toPrivacyPolicy(model) }.flatten() }
    }
}
