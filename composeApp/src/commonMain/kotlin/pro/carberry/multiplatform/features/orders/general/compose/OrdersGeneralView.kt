package pro.carberry.multiplatform.features.orders.general.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.new_order
import carberry.composeapp.generated.resources.no_orders_yet
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.core.compose.button.CarberryActionButton
import pro.carberry.multiplatform.core.extensions.icons.CarConfig
import pro.carberry.multiplatform.features.orders.general.presentation.models.OrdersGeneralEvent
import pro.carberry.multiplatform.features.orders.general.presentation.models.OrdersGeneralEvent.NewOrderClick
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun OrdersGeneralView(
    eventHandler: (OrdersGeneralEvent) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(120.dp),
                imageVector = Icons.CarConfig,
                contentDescription = stringResource(Res.string.no_orders_yet),
                colorFilter = ColorFilter.tint(AppTheme.colors.primaryText)
            )

            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                style = AppTheme.typography.smallHeading,
                text = stringResource(Res.string.no_orders_yet),
                color = AppTheme.colors.primaryText,
                textAlign = TextAlign.Center
            )
        }

        CarberryActionButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(Res.string.new_order),
            enabled = true,
            onClick = { eventHandler(NewOrderClick) }
        )
    }
}
