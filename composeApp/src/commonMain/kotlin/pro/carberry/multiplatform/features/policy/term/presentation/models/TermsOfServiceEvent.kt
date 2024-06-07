package pro.carberry.multiplatform.features.policy.term.presentation.models

sealed interface TermsOfServiceEvent {
    data object BackClick : TermsOfServiceEvent
    data object RefundPolicyClick : TermsOfServiceEvent
    data object PrivacyPolicyClick : TermsOfServiceEvent
}
