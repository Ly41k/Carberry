package pro.carberry.multiplatform.features.policy.privacy.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import carberry.composeapp.generated.resources.Res
import carberry.composeapp.generated.resources.privacy_policy
import carberry.composeapp.generated.resources.refund_policy
import carberry.composeapp.generated.resources.terms_of_service
import pro.carberry.multiplatform.core.compose.policy.PolicyLinksView
import pro.carberry.multiplatform.core.compose.policy.PolicyTitleView
import pro.carberry.multiplatform.core.compose.policy.PolicyViewText
import pro.carberry.multiplatform.core.compose.topbar.CarberryTopAppBar
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyEvent
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyEvent.BackClick
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyEvent.RefundPolicyClick
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyEvent.TermsOfServiceClick
import pro.carberry.multiplatform.features.policy.privacy.presentation.models.PrivacyPolicyViewState
import pro.carberry.multiplatform.theme.AppTheme

@Composable
fun PrivacyPolicyView(
    state: PrivacyPolicyViewState,
    eventHandler: (PrivacyPolicyEvent) -> Unit
) {

    Scaffold(
        topBar = {
            CarberryTopAppBar(
                modifier = Modifier,
                title = Res.string.privacy_policy,
                isBackButtonShowed = true,
                popUp = { eventHandler(BackClick) }
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
                        item { PolicyTitleView(Res.string.privacy_policy) }

                        items(state.policy) { policy -> PolicyViewText(policy, false) }

                        item {
                            HorizontalDivider(
                                modifier = Modifier.fillMaxWidth(1f),
                                thickness = 1.dp,
                                color = AppTheme.colors.secondaryText
                            )
                        }

                        item {
                            PolicyLinksView(
                                startLinkName = Res.string.terms_of_service,
                                endLinkName = Res.string.refund_policy,
                                onStartLinkClick = { eventHandler(TermsOfServiceClick) },
                                onEndLinkClick = { eventHandler(RefundPolicyClick) }
                            )
                        }
                    }
                }
            }
        }
    )
}
