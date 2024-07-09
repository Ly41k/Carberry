package pro.carberry.multiplatform.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.core.compose.button.CarberryActionButton
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateWithPopBackStack
import pro.carberry.multiplatform.theme.AppTheme
import pro.carberry.multiplatform.theme.DefaultNavigationBarItemColors

@Composable
fun MainAppGraph() {
    val navController = LocalRootNavHostController.current
    val navBottomBarController = rememberNavController()

    Scaffold(bottomBar = { BottomNavigationUI(navBottomBarController) }) { innerPadding ->
        Box(
            modifier = Modifier
                .background(AppTheme.colors.primaryBackground)
                .padding(innerPadding)

        ) {
            NavHost(
                startDestination = MainNavigation.Home.route,
                navController = navBottomBarController,
                modifier = Modifier.fillMaxSize()
            ) {
                homeGraph(navController)
                ordersGraph(navController)
                profileGraph(navController)
            }
        }
    }
}

private fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    navigation(
        startDestination = HomeAppScreens.Home.name,
        route = MainNavigation.Home.route
    ) {
        composable(route = HomeAppScreens.Home.name) {
            Column(
                modifier = Modifier.fillMaxWidth().systemBarsPadding().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                    style = AppTheme.typography.mediumHeading,
                    text = "Home",
                    color = AppTheme.colors.primaryText,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                    style = AppTheme.typography.smallHeading,
                    text = "Will be added soon",
                    textAlign = TextAlign.Center,
                    color = AppTheme.colors.secondaryText
                )

                CarberryActionButton(
                    modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
                    text = "Logout",
                    enabled = true,
                    onClick = { navController.navigateWithPopBackStack(RootAppScreens.Splash.name) }
                )
            }
        }
    }
}

private fun NavGraphBuilder.ordersGraph(navController: NavHostController) {
    navigation(
        startDestination = OrdersAppScreens.Orders.name,
        route = MainNavigation.Orders.route
    ) {
        composable(route = OrdersAppScreens.Orders.name) {
            Column(
                modifier = Modifier.fillMaxWidth().systemBarsPadding().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                    style = AppTheme.typography.mediumHeading,
                    text = "Orders",
                    color = AppTheme.colors.primaryText,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                    style = AppTheme.typography.smallHeading,
                    text = "Will be added soon",
                    textAlign = TextAlign.Center,
                    color = AppTheme.colors.secondaryText
                )

                CarberryActionButton(
                    modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
                    text = "Logout",
                    enabled = true,
                    onClick = { navController.navigateWithPopBackStack(RootAppScreens.Splash.name) }
                )
            }
        }
    }
}

private fun NavGraphBuilder.profileGraph(navController: NavHostController) {

    navigation(
        startDestination = ProfileAppScreens.Profile.name,
        route = MainNavigation.Profile.route
    ) {
        composable(route = ProfileAppScreens.Profile.name) {
            Column(
                modifier = Modifier.fillMaxWidth().systemBarsPadding().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                    style = AppTheme.typography.mediumHeading,
                    text = "Profile",
                    color = AppTheme.colors.primaryText,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                    style = AppTheme.typography.smallHeading,
                    text = "Will be added soon",
                    textAlign = TextAlign.Center,
                    color = AppTheme.colors.secondaryText
                )

                CarberryActionButton(
                    modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
                    text = "Logout",
                    enabled = true,
                    onClick = { navController.navigateWithPopBackStack(RootAppScreens.Splash.name) }
                )
            }
        }
    }
}

@Composable
fun BottomNavigationUI(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Card(
        modifier = Modifier.fillMaxWidth().background(AppTheme.colors.primaryBackground),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp)
    ) {

        NavigationBar(
            containerColor = AppTheme.colors.primaryBackground,
            contentColor = AppTheme.colors.primaryBackground,
            tonalElevation = 8.dp
        ) {

            val items = listOf(MainNavigation.Home, MainNavigation.Orders, MainNavigation.Profile)
            items.forEach { screen ->
                val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                NavigationBarItem(label = { Text(text = stringResource(screen.title), fontSize = 10.sp) },
                    selected = isSelected,
                    icon = {
                        when (screen) {
                            MainNavigation.Home,
                            MainNavigation.Orders,
                            MainNavigation.Profile -> TabItemIcon(screen, isSelected)
                        }
                    },
                    colors = DefaultNavigationBarItemColors(),
                    onClick = {
                        navController.navigate(screen.route) {
                            // Pop up to  the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().displayName) { saveState = true }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    })
            }
        }
    }
}

@Composable
fun TabItemIcon(navItem: MainNavigation, isSelected: Boolean) {
    Icon(
        modifier = Modifier.size(24.dp),
        imageVector = if (isSelected) navItem.selectedIcon else navItem.unselectedIcon,
        contentDescription = stringResource(navItem.title)
    )
}
