package pro.carberry.multiplatform.mappers

import pro.carberry.multiplatform.core.exceptions.ExceptionService
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicyDescription
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicyDescriptionRes
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicyListItemRes
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicySmallTitle
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicySmallTitleRes
import pro.carberry.multiplatform.repositories.policy.models.LocalPolicyModel
import pro.carberry.multiplatform.repositories.policy.models.PolicyModel
import pro.carberry.multiplatform.repositories.policy.models.RemotePolicyModel

interface PolicyMapper {
    fun toTermsOfService(model: PolicyModel): List<PolicyViewItem>
    fun toRefundPolicy(model: PolicyModel): List<PolicyViewItem>
}

class PolicyMapperImpl(
    private val exceptionService: ExceptionService
) : PolicyMapper {

    override fun toTermsOfService(model: PolicyModel): List<PolicyViewItem> {
        return when (model) {
            is LocalPolicyModel -> buildList {
                add(PolicySmallTitleRes(model.title))
                addAll(model.descriptions.map {
                    if (it.offset) PolicyListItemRes(it.description)
                    else PolicyDescriptionRes(it.description)
                })
            }

            is RemotePolicyModel -> buildList {
                add(PolicySmallTitle(model.title))
                add(PolicyDescription(model.descriptions))
            }

            else -> {
                exceptionService.logException(UnsupportedOperationException("Unsupported policy type"))
                emptyList()
            }
        }
    }

    override fun toRefundPolicy(model: PolicyModel): List<PolicyViewItem> {
        return when (model) {
            is LocalPolicyModel -> buildList { addAll(model.descriptions.map { PolicyDescriptionRes(it.description) }) }

            is RemotePolicyModel -> buildList { add(PolicyDescription(model.descriptions)) }

            else -> {
                exceptionService.logException(UnsupportedOperationException("Unsupported policy type"))
                emptyList()
            }
        }
    }
}
