package pro.carberry.multiplatform.repositories.policy.models

import org.jetbrains.compose.resources.StringResource

abstract class PolicyModel(open val title: Any, open val descriptions: Any)

data class RemotePolicyModel(
    override val title: String,
    override val descriptions: String
) : PolicyModel(title, descriptions)

data class LocalPolicyModel(
    override val title: StringResource,
    override val descriptions: List<Description>
) : PolicyModel(title, descriptions) {

    data class Description(
        val description: StringResource,
        val offset: Boolean = false
    )
}

fun StringResource.toDescription(offset: Boolean = false): LocalPolicyModel.Description {
    return LocalPolicyModel.Description(this, offset)
}
