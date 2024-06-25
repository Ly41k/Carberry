package pro.carberry.multiplatform.features.policy.privacy.presentation.models

sealed interface PrivacyPolicyEvent {
    data object BackClick : PrivacyPolicyEvent
    data object RefundPolicyClick : PrivacyPolicyEvent
    data object TermsOfServiceClick : PrivacyPolicyEvent
}
