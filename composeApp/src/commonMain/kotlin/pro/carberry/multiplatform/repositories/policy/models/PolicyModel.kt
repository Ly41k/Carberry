package pro.carberry.multiplatform.repositories.policy.models

import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString

abstract class PolicyModel(open val title: Any, open val descriptions: Any)

data class RemotePolicyModel(
    override val title: String,
    override val descriptions: String
) : PolicyModel(title, descriptions)

data class LocalPolicyModel(
    override val title: String,
    override val descriptions: List<Description>
) : PolicyModel(title, descriptions) {

    data class Description(
        val description: String,
        val offset: Boolean = false
    )
}

suspend fun StringResource.toDescription(offset: Boolean = false, args: Any? = null): LocalPolicyModel.Description {
    val description = args?.let { getString(this, it) } ?: getString(this)
    return LocalPolicyModel.Description(description, offset)
}

suspend fun StringResource.mapToString(): String = getString(this)
