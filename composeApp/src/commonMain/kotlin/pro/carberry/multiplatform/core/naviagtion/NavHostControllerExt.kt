package pro.carberry.multiplatform.core.naviagtion

import androidx.navigation.NavHostController

fun NavHostController.navigateWithClearAction(route: String, clearAction: () -> Unit) {
    navigate(route)
    clearAction.invoke()
}

fun NavHostController.navigateWithPopBackStack(route: String) {
    popBackStack()
    navigate(route)
}
