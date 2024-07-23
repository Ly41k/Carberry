package pro.carberry.multiplatform.core.compose.dropmenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import pro.carberry.multiplatform.core.compose.dropmenu.models.DropItemModel
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun CarberryOutlinedTextFieldWithDropMenu(
    modifier: Modifier = Modifier,
    items: List<DropItemModel>,
    selectedItem: DropItemModel?,
    hint: String,
    textFieldSize: Size,
    icon: ImageVector,
    isExpanded: Boolean,
    onDropMenuExpanded: () -> Unit,
    onTextChanged: (String) -> Unit,
    onTextFieldSizeChanged: (Size) -> Unit
) {
    Box(modifier = modifier) {
        OutlinedTextField(
            value = selectedItem?.name.orEmpty(),
            enabled = false,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates -> onTextFieldSizeChanged(coordinates.size.toSize()) }
                .clickable { onDropMenuExpanded() },
            label = { Text(text = hint, color = AppTheme.colors.secondaryText) },
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = AppTheme.colors.primaryText,
                disabledContainerColor = AppTheme.colors.primaryBackground,
                disabledBorderColor = AppTheme.colors.secondaryBackground,
            ),
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = hint,
                    modifier = Modifier.clickable { onDropMenuExpanded.invoke() })
            }
        )
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { onDropMenuExpanded.invoke() },
            modifier = Modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            items.forEach { model ->
                DropdownMenuItem(
                    text = { Text(text = model.name) },
                    onClick = {
                        onTextChanged.invoke(model.name)
                        onDropMenuExpanded.invoke()
                    }
                )
            }
        }
    }
}
