package pro.carberry.multiplatform.theme.models

import androidx.compose.ui.graphics.Color
import pro.carberry.multiplatform.theme.ColorRes

data class AppColors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val primaryAction: Color,
    val error: Color = ColorRes.errorColor
)
