package pro.carberry.multiplatform.features.auth.register.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.core.naviagtion.LocalRootNavHostController
import pro.carberry.multiplatform.features.auth.register.presentation.RegistrationViewModel
import pro.carberry.multiplatform.features.auth.register.presentation.models.RegistrationAction.OpenPreviousScreen

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = viewModel { RegistrationViewModel() }
) {

    val navController = LocalRootNavHostController.current

    val action by viewModel.viewActions().observeAsState()
    RegistrationView { event -> viewModel.obtainEvent(event) }

    when (action) {
        OpenPreviousScreen -> navController.popBackStack()
        null -> {
            /* Do nothing*/
        }
    }
}
