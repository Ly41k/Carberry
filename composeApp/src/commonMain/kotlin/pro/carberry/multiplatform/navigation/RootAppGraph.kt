package pro.carberry.multiplatform.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.features.auth.forgot.compose.ForgotPasswordScreen
import pro.carberry.multiplatform.features.auth.login.compose.LoginScreen
import pro.carberry.multiplatform.features.auth.reset.compose.ResetPasswordScreen
import pro.carberry.multiplatform.features.policy.privacy.PrivacyPolicyScreen
import pro.carberry.multiplatform.features.policy.refund.compose.RefundPolicyScreen
import pro.carberry.multiplatform.features.policy.term.TermsOfServiceScreen
import pro.carberry.multiplatform.features.splash.compose.SplashScreen
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun RootAppGraph(navController: NavHostController = rememberNavController()) {
    CompositionLocalProvider(
        LocalRootNavHostController provides navController
    ) {
        NavHost(
            modifier = Modifier.fillMaxSize().background(AppTheme.colors.primaryBackground),
            navController = navController,
            startDestination = RootAppScreens.Splash.name
        ) {
            composable(route = RootAppScreens.Splash.name) { SplashScreen() }
            authGraph()
            policyGraph()
            composable(route = RootAppScreens.Main.name) { MainAppGraph() }
        }
    }
}

fun NavGraphBuilder.authGraph() {
    navigation(
        startDestination = AuthAppScreens.Login.name,
        route = RootAppScreens.AuthFlow.name
    ) {
        composable(route = AuthAppScreens.Login.name) { LoginScreen() }
        composable(route = AuthAppScreens.ForgotPassword.name) { ForgotPasswordScreen() }
        composable(route = AuthAppScreens.ResetPassword.name) { ResetPasswordScreen() }
    }
}

fun NavGraphBuilder.policyGraph() {
    navigation(
        startDestination = PolicyAppScreens.Privacy.name,
        route = RootAppScreens.PolicyFlow.name
    ) {
        composable(route = PolicyAppScreens.Privacy.name) { PrivacyPolicyScreen() }
        composable(route = PolicyAppScreens.Refund.name) { RefundPolicyScreen() }
        composable(route = PolicyAppScreens.TermsOfService.name) { TermsOfServiceScreen() }
    }
}
