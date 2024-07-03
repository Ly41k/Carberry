package pro.carberry.multiplatform.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pro.carberry.multiplatform.core.compose.button.CarberryActionButton
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.core.naviagtion.navigateWithPopBackStack
import pro.carberry.multiplatform.navigation.RootAppScreens.Splash
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun MainAppGraph() {

    val navController = LocalRootNavHostController.current

    Column(
        modifier = Modifier.fillMaxWidth().systemBarsPadding().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            style = AppTheme.typography.mediumHeading,
            text = "Home/Orders/Profile ",
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
            onClick = { navController.navigateWithPopBackStack(Splash.name) }
        )
    }
}
