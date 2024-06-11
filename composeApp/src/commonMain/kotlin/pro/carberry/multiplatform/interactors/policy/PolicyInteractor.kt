package pro.carberry.multiplatform.interactors.policy

import kotlinx.coroutines.flow.Flow
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem

interface PolicyInteractor {
    fun getTermsOfService(): Flow<List<PolicyViewItem>>
    fun getRefundPolicy(): Flow<List<PolicyViewItem>>
    fun getPrivacyPolicy(): Flow<List<PolicyViewItem>>
}
