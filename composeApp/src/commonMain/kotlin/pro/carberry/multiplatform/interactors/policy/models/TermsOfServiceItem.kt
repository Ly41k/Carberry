package pro.carberry.multiplatform.interactors.policy.models

import org.jetbrains.compose.resources.StringResource

sealed class PolicyViewItem(open val value: Any) {
    data class PolicyLargeTitle(override val value: String) : PolicyViewItem(value)
    data class PolicyLargeTitleRes(override val value: StringResource) : PolicyViewItem(value)
    data class PolicyMediumTitle(override val value: String) : PolicyViewItem(value)
    data class PolicyMediumTitleRes(override val value: StringResource) : PolicyViewItem(value)
    data class PolicySmallTitle(override val value: String) : PolicyViewItem(value)
    data class PolicySmallTitleRes(override val value: StringResource) : PolicyViewItem(value)
    data class PolicyDescription(override val value: String) : PolicyViewItem(value)
    data class PolicyDescriptionRes(override val value: StringResource) : PolicyViewItem(value)
    data class PolicyListItem(override val value: String) : PolicyViewItem(value)
    data class PolicyListItemRes(override val value: StringResource) : PolicyViewItem(value)
}
