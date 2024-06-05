package pro.carberry.multiplatform.features.policy.refund.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.privacy_policy
import carberry.composeapp.generated.resources.refund_description
import carberry.composeapp.generated.resources.refund_policy
import carberry.composeapp.generated.resources.terms_of_service
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import pro.carberry.multiplatform.core.compose.topbar.CarberryTopAppBar
import pro.carberry.multiplatform.features.policy.refund.presentation.models.RefundPolicyEvent
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun RefundPolicyView(eventHandler: (RefundPolicyEvent) -> Unit) {
    Scaffold(
        topBar = {
            CarberryTopAppBar(
                modifier = Modifier,
                title = Res.string.refund_policy,
                isBackButtonShowed = true,
                popUp = { eventHandler(RefundPolicyEvent.BackClick) }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(AppTheme.colors.primaryBackground),
                contentAlignment = Alignment.TopCenter
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth().padding(16.dp).wrapContentHeight(),
                    shadowElevation = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                    tonalElevation = 16.dp,
                    color = AppTheme.colors.primaryBackground
                ) {
                    LazyColumn(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        item { PolicyTitleView(Res.string.refund_policy) }

                        item {
                            Text(
                                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                                text = stringResource(Res.string.refund_description),
                                style = AppTheme.typography.normalText,
                                textAlign = TextAlign.Justify,
                                color = AppTheme.colors.primaryText
                            )
                        }

                        item {
                            HorizontalDivider(
                                modifier = Modifier.fillMaxWidth(1f),
                                thickness = 1.dp,
                                color = AppTheme.colors.secondaryText
                            )
                        }

                        item {
                            PolicyLinksView(
                                startLinkName = Res.string.privacy_policy,
                                endLinkName = Res.string.terms_of_service,
                                onStartLinkClick = { eventHandler(RefundPolicyEvent.PrivacyPolicyClick) },
                                onEndLinkClick = { eventHandler(RefundPolicyEvent.TermsOfServiceClick) }
                            )
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun PolicyTitleView(title: StringResource) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = AppTheme.colors.secondaryText
        )
        Text(
            modifier = Modifier.padding(horizontal = 6.dp),
            text = stringResource(title),
            color = AppTheme.colors.secondaryText,
            style = AppTheme.typography.smallHeading
        )
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = AppTheme.colors.secondaryText
        )
    }
}

@Composable
fun PolicyLinksView(
    startLinkName: StringResource,
    endLinkName: StringResource,
    onStartLinkClick: () -> Unit,
    onEndLinkClick: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
        Text(
            modifier = Modifier.clickable { onStartLinkClick() },
            text = stringResource(startLinkName),
            style = AppTheme.typography.mediumText,
            color = AppTheme.colors.primaryAction
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.clickable { onEndLinkClick() },
            text = stringResource(endLinkName),
            style = AppTheme.typography.mediumText,
            color = AppTheme.colors.primaryAction
        )
    }
}
