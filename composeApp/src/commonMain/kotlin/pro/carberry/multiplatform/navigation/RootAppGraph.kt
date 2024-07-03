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
import pro.carberry.multiplatform.features.auth.register.compose.RegistrationScreen
import pro.carberry.multiplatform.features.auth.reset.compose.ResetPasswordScreen
import pro.carberry.multiplatform.features.policy.privacy.compose.PrivacyPolicyScreen
import pro.carberry.multiplatform.features.policy.refund.compose.RefundPolicyScreen
import pro.carberry.multiplatform.features.policy.term.compose.TermsOfServiceScreen
import pro.carberry.multiplatform.features.splash.compose.SplashScreen
import pro.carberry.multiplatform.navigation.AuthAppScreens.ForgotPassword
import pro.carberry.multiplatform.navigation.AuthAppScreens.Login
import pro.carberry.multiplatform.navigation.AuthAppScreens.Register
import pro.carberry.multiplatform.navigation.AuthAppScreens.ResetPassword
import pro.carberry.multiplatform.navigation.PolicyAppScreens.Privacy
import pro.carberry.multiplatform.navigation.PolicyAppScreens.Refund
import pro.carberry.multiplatform.navigation.PolicyAppScreens.TermsOfService
import pro.carberry.multiplatform.navigation.RootAppScreens.AuthFlow
import pro.carberry.multiplatform.navigation.RootAppScreens.Main
import pro.carberry.multiplatform.navigation.RootAppScreens.PolicyFlow
import pro.carberry.multiplatform.navigation.RootAppScreens.Splash
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun RootAppGraph(navController: NavHostController = rememberNavController()) {
    CompositionLocalProvider(
        LocalRootNavHostController provides navController
    ) {
        NavHost(
            modifier = Modifier.fillMaxSize().background(AppTheme.colors.primaryBackground),
            navController = navController,
            startDestination = Splash.name
        ) {
            composable(route = Splash.name) { SplashScreen() }
            authGraph()
            policyGraph()
            composable(route = Main.name) { MainAppGraph() }
        }
    }
}

fun NavGraphBuilder.authGraph() {
    navigation(
        startDestination = Login.name,
        route = AuthFlow.name
    ) {
        composable(route = Login.name) { LoginScreen() }
        composable(route = ForgotPassword.name) { ForgotPasswordScreen() }
        composable(route = ResetPassword.name) { ResetPasswordScreen() }
        composable(route = Register.name) { RegistrationScreen() }
    }
}

fun NavGraphBuilder.policyGraph() {
    navigation(
        startDestination = Privacy.name,
        route = PolicyFlow.name
    ) {
        composable(route = Privacy.name) { PrivacyPolicyScreen() }
        composable(route = Refund.name) { RefundPolicyScreen() }
        composable(route = TermsOfService.name) { TermsOfServiceScreen() }
    }
}
