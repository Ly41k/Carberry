package pro.carberry.multiplatform.features.policy.refund.presentation.models

import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem

data class RefundPolicyViewState(val policy: List<PolicyViewItem> = emptyList())
