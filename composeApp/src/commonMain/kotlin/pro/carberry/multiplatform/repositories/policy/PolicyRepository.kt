package pro.carberry.multiplatform.repositories.policy

import pro.carberry.multiplatform.repositories.policy.models.PolicyModel

interface PolicyRepository {
    suspend fun getTermsOfServicePolicy(): List<PolicyModel>
    suspend fun getRefundPolicy(): List<PolicyModel>
    suspend fun getPrivacyPolicy(): List<PolicyModel>
}
