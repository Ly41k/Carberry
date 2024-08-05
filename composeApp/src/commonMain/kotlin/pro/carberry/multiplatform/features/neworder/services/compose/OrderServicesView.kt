package pro.carberry.multiplatform.features.neworder.services.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.back
import carberry.composeapp.generated.resources.create_new_order
import carberry.composeapp.generated.resources.final_amount
import carberry.composeapp.generated.resources.next_continue
import carberry.composeapp.generated.resources.services
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.core.compose.button.CarberryActionButton
import pro.carberry.multiplatform.core.compose.topbar.CarberryOrderTopAppBar
import pro.carberry.multiplatform.features.neworder.services.presentation.models.OrderServicesEvent
import pro.carberry.multiplatform.features.neworder.services.presentation.models.OrderServicesViewState
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun OrderServicesView(
    state: OrderServicesViewState,
    eventHandler: (OrderServicesEvent) -> Unit
) {
    Scaffold(
        topBar = {
            CarberryOrderTopAppBar(
                titleRes = Res.string.create_new_order,
                popUp = { eventHandler(OrderServicesEvent.BackClick) }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier.padding(padding)
                    .fillMaxSize()
                    .background(AppTheme.colors.primaryBackground)
                    .padding(horizontal = 16.dp)
            ) {
                LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f))
                {
                    item {
                        Text(
                            modifier = Modifier.fillMaxWidth().padding(16.dp),
                            text = stringResource(Res.string.services),
                            style = AppTheme.typography.mediumHeading,
                            textAlign = TextAlign.Center,
                            color = AppTheme.colors.secondaryText
                        )
                    }

                    items(state.services) { service ->
                        OrderServicesItemView(
                            serviceName = service.serviceName,
                            serviceAmount = service.serviceAmount,
                            serviceExtraInfo = service.serviceExtraInfo,
                            isServiceAdded = service.isServiceAdded,
                            onServiceStateChanged = { eventHandler.invoke(OrderServicesEvent.ServiceStateChanged(service.id)) }
                        )
                    }

                    item {
                        Text(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                            text = stringResource(Res.string.final_amount, "0"),
                            style = AppTheme.typography.smallHeading,
                            color = AppTheme.colors.secondaryText,
                            textAlign = TextAlign.Center
                        )
                    }
                    item {
                        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
                            CarberryActionButton(
                                modifier = Modifier.weight(1f).padding(end = 2.dp),
                                text = stringResource(Res.string.back),
                                enabled = true,
                                onClick = { eventHandler.invoke(OrderServicesEvent.BackClick) }
                            )
                            CarberryActionButton(
                                modifier = Modifier.weight(1f).padding(start = 2.dp),
                                text = stringResource(Res.string.next_continue),
                                enabled = true,
                                onClick = { eventHandler.invoke(OrderServicesEvent.ContinueClick) }
                            )
                        }
                    }
                }
            }
        }
    )
}
