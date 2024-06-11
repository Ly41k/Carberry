package pro.carberry.multiplatform.features.policy.term.presentation.models

import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem

data class TermsOfServiceViewState(val policy: List<PolicyViewItem> = emptyList())
