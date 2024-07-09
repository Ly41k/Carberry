package pro.carberry.multiplatform.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Task
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Task
import androidx.compose.ui.graphics.vector.ImageVector
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.home
import carberry.composeapp.generated.resources.orders
import carberry.composeapp.generated.resources.profile
import org.jetbrains.compose.resources.StringResource

sealed class MainNavigation(
    val route: String,
    val title: StringResource,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    data object Home : MainNavigation(
        route = MainAppScreens.HomeFlow.name,
        title = Res.string.home,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )

    data object Orders : MainNavigation(
        route = MainAppScreens.OrdersFLow.name,
        title = Res.string.orders,
        selectedIcon = Icons.Filled.Task,
        unselectedIcon = Icons.Outlined.Task
    )

    data object Profile : MainNavigation(
        route = MainAppScreens.ProfileFlow.name,
        title = Res.string.profile,
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person
    )
}
