package pro.carberry.multiplatform.repositories.policy.models

import org.jetbrains.compose.resources.StringResource

abstract class PolicyModel(open val title: Any, open val description: Any)

data class RemotePolicyModel(
    override val title: String,
    override val description: String
) : PolicyModel(title, description)

data class LocalPolicyModel(
    override val title: StringResource,
    override val description: StringResource
) : PolicyModel(title, description)
