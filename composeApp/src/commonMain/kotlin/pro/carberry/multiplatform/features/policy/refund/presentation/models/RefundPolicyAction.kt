package pro.carberry.multiplatform.features.policy.refund.presentation.models

sealed interface RefundPolicyAction {
    data object OpenPreviousScreen : RefundPolicyAction
    data object OpenPrivacyPolicy : RefundPolicyAction
    data object OpenTermsOfService : RefundPolicyAction
}
