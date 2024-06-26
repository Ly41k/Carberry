package pro.carberry.multiplatform.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pro.carberry.multiplatform.theme.models.AppTypographies

val typography = AppTypographies(
    largeHeading = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 38.sp
    ),
    mediumHeading = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 34.sp
    ),
    smallHeading = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    mediumText = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 24.sp
    ),
    normalText = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp
    ),
    label = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 22.sp
    )
)

internal val LocalAppTypographies = staticCompositionLocalOf<AppTypographies> {
    error("No font provided")
}
