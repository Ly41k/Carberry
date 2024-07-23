package pro.carberry.multiplatform.features.neworder.maininfo.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import carberry.composeapp.generated.resources.create_new_order
import carberry.composeapp.generated.resources.main_information
import carberry.composeapp.generated.resources.next_continue
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.core.compose.button.CarberryActionButton
import pro.carberry.multiplatform.core.compose.dropmenu.CarberryOutlinedTextFieldWithDropMenu
import pro.carberry.multiplatform.core.compose.topbar.CarberryOrderTopAppBar
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent.BackClick
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent.ContinueClick
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent.DropMenuExpanded
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent.SelectedTypeChanged
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoEvent.TextFieldSizeChanged
import pro.carberry.multiplatform.features.neworder.maininfo.presentation.models.OrderMainInfoViewState
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun OrderMainInfoView(
    state: OrderMainInfoViewState,
    eventHandler: (OrderMainInfoEvent) -> Unit
) {

    Scaffold(
        topBar = {
            CarberryOrderTopAppBar(
                titleRes = Res.string.create_new_order,
                popUp = { eventHandler(BackClick) }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier.padding(padding)
                    .fillMaxSize()
                    .background(AppTheme.colors.primaryBackground)
                    .padding(horizontal = 16.dp)
            ) {
                LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {
                    item {
                        Text(
                            modifier = Modifier.fillMaxWidth().padding(16.dp),
                            text = stringResource(Res.string.main_information),
                            style = AppTheme.typography.mediumHeading,
                            textAlign = TextAlign.Center,
                            color = AppTheme.colors.secondaryText
                        )
                    }

                    items(state.groups) { groupModel ->
                        CarberryOutlinedTextFieldWithDropMenu(
                            modifier = Modifier.padding(bottom = 8.dp),
                            items = groupModel.items,
                            selectedItem = groupModel.selectedItem,
                            hint = groupModel.type.groupName,
                            isExpanded = groupModel.isDropMenuExpanded,
                            icon = groupModel.getDropMenuIcon(),
                            textFieldSize = groupModel.textFieldSize,
                            onDropMenuExpanded = { eventHandler(DropMenuExpanded(groupModel.type)) },
                            onTextChanged = { eventHandler(SelectedTypeChanged(groupModel.type, it)) },
                            onTextFieldSizeChanged = { eventHandler(TextFieldSizeChanged(groupModel.type, it)) }
                        )
                    }
                }

                CarberryActionButton(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                    text = stringResource(Res.string.next_continue),
                    enabled = true,
                    onClick = { eventHandler(ContinueClick) }
                )
            }
        }
    )
}
