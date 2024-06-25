package pro.carberry.multiplatform.features.policy.privacy.presentation.models

import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem

data class PrivacyPolicyViewState(val policy: List<PolicyViewItem> = emptyList())
