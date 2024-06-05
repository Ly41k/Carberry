package pro.carberry.multiplatform.core.naviagtion

import androidx.navigation.NavHostController
import pro.carberry.multiplatform.navigation.PolicyAppScreens

fun NavHostController.navigateToRefundPolicy() {
    navigate(PolicyAppScreens.Refund.name)
}

fun NavHostController.navigateToTermsOfService() {
    navigate(PolicyAppScreens.TermsOfService.name)
}
