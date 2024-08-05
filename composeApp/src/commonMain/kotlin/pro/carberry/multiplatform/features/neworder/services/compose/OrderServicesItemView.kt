package pro.carberry.multiplatform.features.neworder.services.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun OrderServicesItemView(
    modifier: Modifier = Modifier,
    serviceName: String,
    serviceAmount: Long,
    serviceExtraInfo: String,
    isServiceAdded: Boolean,
    onServiceStateChanged: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        shape = RoundedCornerShape(10.dp),
        contentColor = AppTheme.colors.primaryText,
        color = AppTheme.colors.primaryBackground,
        border = BorderStroke(1.dp, AppTheme.colors.secondaryBackground)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(50)),
                    painter = ColorPainter(AppTheme.colors.secondaryBackground),
                    contentDescription = serviceName
                )

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp, end = 4.dp),
                    text = serviceName,
                    color = AppTheme.colors.secondaryText,
                    style = AppTheme.typography.normalText
                )

                Text(
                    modifier = Modifier.padding(start = 4.dp, end = 16.dp),
                    text = "$serviceAmount €",
                    color = AppTheme.colors.secondaryText,
                    style = AppTheme.typography.mediumText
                )

                Switch(
                    modifier = Modifier,
                    checked = isServiceAdded,
                    onCheckedChange = { onServiceStateChanged() },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = AppTheme.colors.primaryAction,
                        checkedTrackColor = AppTheme.colors.primaryText,
                        uncheckedThumbColor = AppTheme.colors.secondaryBackground,
                        uncheckedTrackColor = AppTheme.colors.secondaryText,
                    ),
                    thumbContent = if (isServiceAdded) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = null,
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                            )
                        }
                    } else {
                        null
                    }
                )
            }

            if (isServiceAdded && serviceExtraInfo.isNotBlank()) {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    thickness = 1.dp,
                    color = AppTheme.colors.secondaryBackground
                )

                Text(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    style = AppTheme.typography.normalText,
                    text = buildAnnotatedString {
                        withStyle(style = (SpanStyle(fontWeight = FontWeight.Bold))) {
                            append("Additional information: ")
                        }
                        append(serviceExtraInfo)
                    },
                    color = AppTheme.colors.secondaryText
                )
            }
        }
    }
}
