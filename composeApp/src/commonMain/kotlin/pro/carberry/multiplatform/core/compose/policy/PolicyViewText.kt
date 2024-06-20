package pro.carberry.multiplatform.core.compose.policy

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pro.carberry.multiplatform.core.extensions.toUpperCase
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicyClickableItem
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicyDescription
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicyLargeTitle
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicyListItem
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicyMediumTitle
import pro.carberry.multiplatform.interactors.policy.models.PolicyViewItem.PolicySmallTitle
import pro.carberry.multiplatform.theme.AppTheme.colors
import pro.carberry.multiplatform.theme.AppTheme.typography
import sh.calvin.autolinktext.AutoLinkText
import sh.calvin.autolinktext.TextRuleDefaults

@Composable
fun PolicyViewText(item: PolicyViewItem, isTitleUppercase: Boolean = false) {
    when (item) {
        is PolicyDescription -> PolicyDescriptionText(item.value)
        is PolicyListItem -> PolicyDescriptionText(item.value, true)
        is PolicyClickableItem -> PolicyDescriptionClickableText(item.value)
        is PolicyLargeTitle -> PolicyTitleText(item.value.toUpperCase(isTitleUppercase), typography.largeHeading)
        is PolicyMediumTitle -> PolicyTitleText(item.value.toUpperCase(isTitleUppercase), typography.mediumHeading)
        is PolicySmallTitle -> PolicyTitleText(item.value.toUpperCase(isTitleUppercase), typography.smallHeading)
    }
}

@[Composable Stable]
private fun PolicyTitleText(title: String, style: TextStyle) {
    Text(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        text = title,
        style = style,
        textAlign = TextAlign.Start,
        color = colors.primaryText
    )
}

@[Composable Stable]
private fun PolicyDescriptionText(description: String, isListItem: Boolean = false) {
    Text(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 8.dp, start = if (isListItem) 24.dp else 0.dp),
        text = description,
        style = typography.normalText,
        textAlign = TextAlign.Justify,
        color = colors.primaryText
    )
}

@[Composable Stable]
private fun PolicyDescriptionClickableText(description: String) {
    AutoLinkText(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        text = description,
        style = typography.normalText.copy(color = colors.primaryText, textAlign = TextAlign.Justify),
        textRules = TextRuleDefaults.defaultList().map {
            it.copy(
                style =
                SpanStyle(
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = colors.primaryAction,
                    textDecoration = TextDecoration.None
                )
            )
        }
    )
}
