package pro.carberry.multiplatform.features.policy.privacy.presentation.models

sealed interface PrivacyPolicyAction {
    data object OpenPreviousScreen : PrivacyPolicyAction
    data object OpenRefundPolicy : PrivacyPolicyAction
    data object OpenTermsOfService : PrivacyPolicyAction
}
