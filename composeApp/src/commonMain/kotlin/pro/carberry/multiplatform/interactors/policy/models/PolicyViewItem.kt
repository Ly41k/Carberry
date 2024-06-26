package pro.carberry.multiplatform.interactors.policy.models

sealed class PolicyViewItem(open val value: Any) {
    data class PolicyLargeTitle(override val value: String) : PolicyViewItem(value)
    data class PolicyMediumTitle(override val value: String) : PolicyViewItem(value)
    data class PolicySmallTitle(override val value: String) : PolicyViewItem(value)
    data class PolicyDescription(override val value: String) : PolicyViewItem(value)
    data class PolicyListItem(override val value: String) : PolicyViewItem(value)
    data class PolicyClickableItem(override val value: String) : PolicyViewItem(value)
}
