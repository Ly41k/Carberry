package pro.carberry.multiplatform.repositories.policy

import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.refund_description
import carberry.composeapp.generated.resources.refund_policy
import carberry.composeapp.generated.resources.terms_of_service_accuracy
import carberry.composeapp.generated.resources.terms_of_service_accuracy_description
import carberry.composeapp.generated.resources.terms_of_service_general_conditions
import carberry.composeapp.generated.resources.terms_of_service_general_conditions_description
import carberry.composeapp.generated.resources.terms_of_service_modifications
import carberry.composeapp.generated.resources.terms_of_service_modifications_description
import carberry.composeapp.generated.resources.terms_of_service_online_store_terms
import carberry.composeapp.generated.resources.terms_of_service_online_store_terms_description
import carberry.composeapp.generated.resources.terms_of_service_overview
import carberry.composeapp.generated.resources.terms_of_service_overview_description
import carberry.composeapp.generated.resources.terms_of_service_products
import carberry.composeapp.generated.resources.terms_of_service_products_description
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_a
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_b
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_c
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_d
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_e
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_f
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_g
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_h
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_i
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_j
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_k
import carberry.composeapp.generated.resources.terms_of_service_prohibited_uses_description_summary
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import pro.carberry.multiplatform.repositories.policy.models.LocalPolicyModel
import pro.carberry.multiplatform.repositories.policy.models.PolicyModel
import pro.carberry.multiplatform.repositories.policy.models.toDescription

class PolicyRepositoryImpl(
    private val defaultDispatcher: CoroutineDispatcher,
    private val ioDispatcher: CoroutineDispatcher
) : PolicyRepository {

    override suspend fun getTermsOfServicePolicy(): List<PolicyModel> {
        return getRemoteTermsOfService() ?: getLocalTermsOfService()
    }

    override suspend fun getRefundPolicy(): List<PolicyModel> {
        return getRemoteRefundPolicy() ?: getLocalRefundPolicy()
    }

    override suspend fun getPrivacyPolicy(): List<PolicyModel> {
        TODO("Not yet implemented")
    }

    private suspend fun getLocalTermsOfService(): List<PolicyModel> {
        return withContext(defaultDispatcher) {
            return@withContext buildList {
                add(getLocalTermsOfServiceOverview())
                add(getLocalTermsOfServiceOnlineStoreTerms())
                add(getLocalTermsOfServiceGeneralConditions())
                add(getLocalTermsOfServiceAccuracy())
                add(getLocalTermsOfServiceModifications())
                add(getLocalTermsOfServiceProducts())
                add(getLocalTermsOfServiceProhibitedUses())
            }
        }
    }

    private suspend fun getRemoteTermsOfService(): List<PolicyModel>? {
        return withContext(ioDispatcher) {
            // TODO Will be implemented in the future
            return@withContext null
        }
    }

    private suspend fun getLocalRefundPolicy(): List<PolicyModel> {
        return withContext(defaultDispatcher) {
            return@withContext buildList {
                add(
                    LocalPolicyModel(
                        title = Res.string.refund_policy,
                        descriptions = buildList { add(Res.string.refund_description.toDescription()) }
                    )
                )
            }
        }
    }

    private suspend fun getRemoteRefundPolicy(): List<PolicyModel>? {
        return withContext(ioDispatcher) {
            // TODO Will be implemented in the future
            return@withContext null
        }
    }


    private fun getLocalTermsOfServiceOverview(): LocalPolicyModel {
        return LocalPolicyModel(
            title = Res.string.terms_of_service_overview,
            descriptions = buildList { add(Res.string.terms_of_service_overview_description.toDescription()) }
        )
    }

    private fun getLocalTermsOfServiceOnlineStoreTerms(): LocalPolicyModel {
        return LocalPolicyModel(
            title = Res.string.terms_of_service_online_store_terms,
            descriptions = buildList { add(Res.string.terms_of_service_online_store_terms_description.toDescription()) }
        )
    }

    private fun getLocalTermsOfServiceGeneralConditions(): LocalPolicyModel {
        return LocalPolicyModel(
            title = Res.string.terms_of_service_general_conditions,
            descriptions = buildList { add(Res.string.terms_of_service_general_conditions_description.toDescription()) }
        )
    }

    private fun getLocalTermsOfServiceAccuracy(): LocalPolicyModel {
        return LocalPolicyModel(
            title = Res.string.terms_of_service_accuracy,
            descriptions = buildList { add(Res.string.terms_of_service_accuracy_description.toDescription()) }
        )
    }

    private fun getLocalTermsOfServiceModifications(): LocalPolicyModel {
        return LocalPolicyModel(
            title = Res.string.terms_of_service_modifications,
            descriptions = buildList {
                add(Res.string.terms_of_service_modifications_description.toDescription())
                add(Res.string.refund_description.toDescription())
            }
        )
    }

    private fun getLocalTermsOfServiceProducts(): LocalPolicyModel {
        return LocalPolicyModel(
            title = Res.string.terms_of_service_products,
            descriptions = buildList { add(Res.string.terms_of_service_products_description.toDescription()) }
        )
    }

    private fun getLocalTermsOfServiceProhibitedUses(): LocalPolicyModel {
        return LocalPolicyModel(
            title = Res.string.terms_of_service_prohibited_uses,
            descriptions = buildList {
                add(Res.string.terms_of_service_prohibited_uses_description.toDescription())
                add(Res.string.terms_of_service_prohibited_uses_description_a.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_b.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_c.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_d.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_e.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_f.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_g.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_h.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_i.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_j.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_k.toDescription(true))
                add(Res.string.terms_of_service_prohibited_uses_description_summary.toDescription())
            }
        )
    }
}
