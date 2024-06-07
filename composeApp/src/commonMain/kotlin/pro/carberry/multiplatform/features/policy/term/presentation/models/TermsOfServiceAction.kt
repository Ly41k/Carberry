package pro.carberry.multiplatform.features.policy.term.presentation.models

sealed interface TermsOfServiceAction {
    data object OpenPreviousScreen : TermsOfServiceAction
    data object OpenPrivacyPolicy : TermsOfServiceAction
    data object OpenRefundPolicy : TermsOfServiceAction
}
