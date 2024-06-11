package pro.carberry.multiplatform.repositories.policy

import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.terms_of_service_online_store_terms
import carberry.composeapp.generated.resources.terms_of_service_online_store_terms_description
import carberry.composeapp.generated.resources.terms_of_service_overview
import carberry.composeapp.generated.resources.terms_of_service_overview_description
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import pro.carberry.multiplatform.repositories.policy.models.LocalPolicyModel
import pro.carberry.multiplatform.repositories.policy.models.PolicyModel

class PolicyRepositoryImpl : PolicyRepository {

    override suspend fun getTermsOfServicePolicy(): List<PolicyModel> {
        return getRemoteTermsOfService() ?: getLocalTermsOfService()
    }

    private suspend fun getLocalTermsOfService(): List<PolicyModel> {
        // TODO Need to use custom Coroutine Dispatcher
        return withContext(Dispatchers.Default) {
            return@withContext buildList {
                add(getLocalTermsOfServiceOverview())
                add(getLocalTermsOfServiceOnlineStoreTerms())
            }
        }
    }

    private suspend fun getRemoteTermsOfService(): List<PolicyModel>? {
        // TODO Need to use custom Coroutine Dispatcher
        return withContext(Dispatchers.IO) {
            // TODO Will be implemented in the future
            return@withContext null
        }
    }

    private fun getLocalTermsOfServiceOverview(): LocalPolicyModel {
        return LocalPolicyModel(
            title = Res.string.terms_of_service_overview,
            description = Res.string.terms_of_service_overview_description
        )
    }

    private fun getLocalTermsOfServiceOnlineStoreTerms(): LocalPolicyModel {
        return LocalPolicyModel(
            title = Res.string.terms_of_service_online_store_terms,
            description = Res.string.terms_of_service_online_store_terms_description
        )
    }
}
