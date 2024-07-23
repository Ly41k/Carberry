package pro.carberry.multiplatform.core.compose.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.back
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Stable
fun CarberryOrderTopAppBar(
    modifier: Modifier = Modifier,
    titleRes: StringResource,
    isBackButtonShowed: Boolean = true,
    popUp: () -> Unit
) {
    TopAppBar(
        title = {
            Column(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(titleRes),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = AppTheme.colors.primaryText
                )
                // TODO Need to add slider
            }
        },
        navigationIcon = {
            IconButton(
                modifier = Modifier.alpha(if (isBackButtonShowed) 1F else 0F),
                onClick = { popUp.invoke() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    tint = AppTheme.colors.primaryText,
                    contentDescription = stringResource(Res.string.back)
                )
            }
        },
        modifier = modifier.shadow(
            elevation = 5.dp,
            spotColor = AppTheme.colors.secondaryBackground
        ),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = AppTheme.colors.primaryBackground)
    )
}
