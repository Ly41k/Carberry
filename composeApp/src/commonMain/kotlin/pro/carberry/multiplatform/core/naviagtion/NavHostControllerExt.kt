package pro.carberry.multiplatform.core.naviagtion

import androidx.navigation.NavHostController
import pro.carberry.multiplatform.navigation.RootAppScreens

fun NavHostController.navigateToRefundPolicy() {
    navigate(RootAppScreens.RefundPolicy.name)
}

fun NavHostController.navigateToTermsOfService() {
    navigate(RootAppScreens.TermsOfService.name)
}
