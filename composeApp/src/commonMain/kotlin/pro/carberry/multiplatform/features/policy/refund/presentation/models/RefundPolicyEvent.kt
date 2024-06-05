package pro.carberry.multiplatform.features.policy.refund.presentation.models

sealed interface RefundPolicyEvent {
    data object BackClick : RefundPolicyEvent
    data object PrivacyPolicyClick : RefundPolicyEvent
    data object TermsOfServiceClick : RefundPolicyEvent
}
