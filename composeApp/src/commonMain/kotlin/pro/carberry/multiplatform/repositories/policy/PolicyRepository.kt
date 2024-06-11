package pro.carberry.multiplatform.repositories.policy

import pro.carberry.multiplatform.repositories.policy.models.PolicyModel

interface PolicyRepository {
    suspend fun getTermsOfServicePolicy(): List<PolicyModel>
}
