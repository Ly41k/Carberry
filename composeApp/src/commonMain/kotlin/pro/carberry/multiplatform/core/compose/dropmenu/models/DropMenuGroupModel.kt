package pro.carberry.multiplatform.core.compose.dropmenu.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.vector.ImageVector

data class DropMenuGroupModel(
    val type: DropMenuGroupType,
    val items: List<DropItemModel> = emptyList(),
    val selectedItem: DropItemModel? = null,
    val isDropMenuExpanded: Boolean = false,
    val textFieldSize: Size = Size.Zero
) {
    fun getDropMenuIcon(): ImageVector =
        if (isDropMenuExpanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown
}
