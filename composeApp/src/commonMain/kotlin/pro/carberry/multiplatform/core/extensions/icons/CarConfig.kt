package pro.carberry.multiplatform.core.extensions.icons

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.CarConfig: ImageVector
    get() {
        if (_carConfig != null) {
            return _carConfig!!
        }
        _carConfig = Builder(
            name = "carConfig",
            defaultWidth = 800.0.dp,
            defaultHeight = 800.0.dp,
            viewportWidth = 32.0f,
            viewportHeight = 32.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(8.4f, 22.0f)
                lineToRelative(1.2f, -2.3f)
                curveToRelative(0.5f, -1.0f, 1.5f, -1.7f, 2.7f, -1.7f)
                horizontalLineTo(16.0f)
                curveToRelative(1.8f, -2.4f, 4.7f, -4.0f, 8.0f, -4.0f)
                curveToRelative(1.2f, 0.0f, 2.3f, 0.2f, 3.4f, 0.6f)
                curveTo(27.0f, 14.0f, 26.5f, 13.4f, 26.0f, 13.0f)
                horizontalLineToRelative(1.0f)
                curveToRelative(0.6f, 0.0f, 1.0f, -0.4f, 1.0f, -1.0f)
                reflectiveCurveToRelative(-0.4f, -1.0f, -1.0f, -1.0f)
                horizontalLineToRelative(-2.8f)
                lineTo(23.0f, 8.0f)
                curveToRelative(-0.8f, -1.8f, -2.6f, -3.0f, -4.6f, -3.0f)
                horizontalLineTo(9.6f)
                curveTo(7.6f, 5.0f, 5.8f, 6.2f, 5.0f, 8.0f)
                lineToRelative(-1.3f, 3.0f)
                horizontalLineTo(1.0f)
                curveToRelative(-0.6f, 0.0f, -1.0f, 0.4f, -1.0f, 1.0f)
                reflectiveCurveToRelative(0.4f, 1.0f, 1.0f, 1.0f)
                horizontalLineToRelative(1.0f)
                curveToRelative(-1.2f, 0.9f, -2.0f, 2.4f, -2.0f, 4.0f)
                verticalLineToRelative(4.0f)
                curveToRelative(0.0f, 0.9f, 0.4f, 1.7f, 1.0f, 2.2f)
                verticalLineTo(25.0f)
                curveToRelative(0.0f, 1.7f, 1.3f, 3.0f, 3.0f, 3.0f)
                horizontalLineToRelative(2.0f)
                curveToRelative(1.7f, 0.0f, 3.0f, -1.3f, 3.0f, -3.0f)
                verticalLineToRelative(-1.0f)
                horizontalLineToRelative(5.0f)
                curveToRelative(0.0f, -0.7f, 0.1f, -1.4f, 0.2f, -2.0f)
                close()
                moveTo(7.0f, 19.0f)
                horizontalLineTo(4.0f)
                curveToRelative(-0.6f, 0.0f, -1.0f, -0.4f, -1.0f, -1.0f)
                reflectiveCurveToRelative(0.4f, -1.0f, 1.0f, -1.0f)
                horizontalLineToRelative(3.0f)
                curveToRelative(0.6f, 0.0f, 1.0f, 0.4f, 1.0f, 1.0f)
                reflectiveCurveToRelative(-0.4f, 1.0f, -1.0f, 1.0f)
                moveToRelative(-1.5f, -7.0f)
                lineToRelative(1.4f, -3.2f)
                curveTo(7.4f, 7.7f, 8.4f, 7.0f, 9.6f, 7.0f)
                horizontalLineToRelative(8.7f)
                curveToRelative(1.2f, 0.0f, 2.3f, 0.7f, 2.8f, 1.8f)
                lineToRelative(1.4f, 3.2f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(31.7f, 21.9f)
                curveToRelative(-0.1f, -0.5f, -0.7f, -0.8f, -1.2f, -0.7f)
                curveToRelative(-0.7f, 0.2f, -1.2f, 0.0f, -1.3f, -0.2f)
                reflectiveCurveToRelative(0.0f, -0.7f, 0.5f, -1.3f)
                curveToRelative(0.4f, -0.4f, 0.4f, -1.0f, 0.0f, -1.4f)
                quadToRelative(-1.5f, -1.5f, -3.6f, -2.1f)
                curveToRelative(-0.5f, -0.1f, -1.1f, 0.2f, -1.2f, 0.7f)
                curveToRelative(-0.2f, 0.7f, -0.6f, 1.0f, -0.9f, 1.0f)
                reflectiveCurveToRelative(-0.6f, -0.4f, -0.9f, -1.0f)
                curveToRelative(-0.2f, -0.5f, -0.7f, -0.8f, -1.2f, -0.7f)
                quadToRelative(-2.1f, 0.6f, -3.6f, 2.1f)
                curveToRelative(-0.4f, 0.4f, -0.4f, 1.0f, 0.0f, 1.4f)
                curveToRelative(0.5f, 0.5f, 0.6f, 1.0f, 0.5f, 1.3f)
                curveToRelative(-0.1f, 0.2f, -0.6f, 0.4f, -1.3f, 0.2f)
                curveToRelative(-0.5f, -0.1f, -1.1f, 0.2f, -1.2f, 0.7f)
                quadTo(16.0f, 22.95f, 16.0f, 24.0f)
                curveToRelative(0.0f, 1.05f, 0.1f, 1.4f, 0.3f, 2.1f)
                curveToRelative(0.1f, 0.5f, 0.7f, 0.8f, 1.2f, 0.7f)
                curveToRelative(0.7f, -0.2f, 1.2f, 0.0f, 1.3f, 0.2f)
                reflectiveCurveToRelative(0.0f, 0.7f, -0.5f, 1.3f)
                curveToRelative(-0.4f, 0.4f, -0.4f, 1.0f, 0.0f, 1.4f)
                quadToRelative(1.5f, 1.5f, 3.6f, 2.1f)
                curveToRelative(0.5f, 0.1f, 1.1f, -0.2f, 1.2f, -0.7f)
                curveToRelative(0.2f, -0.7f, 0.6f, -1.0f, 0.9f, -1.0f)
                reflectiveCurveToRelative(0.6f, 0.4f, 0.9f, 1.0f)
                curveToRelative(0.1f, 0.4f, 0.5f, 0.7f, 1.0f, 0.7f)
                horizontalLineToRelative(0.3f)
                quadToRelative(2.1f, -0.6f, 3.6f, -2.1f)
                curveToRelative(0.4f, -0.4f, 0.4f, -1.0f, 0.0f, -1.4f)
                curveToRelative(-0.5f, -0.5f, -0.6f, -1.0f, -0.5f, -1.3f)
                curveToRelative(0.1f, -0.2f, 0.6f, -0.4f, 1.3f, -0.2f)
                curveToRelative(0.5f, 0.1f, 1.1f, -0.2f, 1.2f, -0.7f)
                quadToRelative(0.3f, -1.05f, 0.3f, -2.1f)
                curveToRelative(0.0f, -1.05f, -0.2f, -1.4f, -0.4f, -2.1f)
                moveTo(24.0f, 27.0f)
                curveToRelative(-1.7f, 0.0f, -3.0f, -1.3f, -3.0f, -3.0f)
                reflectiveCurveToRelative(1.3f, -3.0f, 3.0f, -3.0f)
                reflectiveCurveToRelative(3.0f, 1.3f, 3.0f, 3.0f)
                reflectiveCurveToRelative(-1.3f, 3.0f, -3.0f, 3.0f)
            }
        }
            .build()
        return _carConfig!!
    }

private var _carConfig: ImageVector? = null
