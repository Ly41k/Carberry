package pro.carberry.multiplatform.features.auth.login.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pro.carberry.multiplatform.core.extensions.collectAsState
import pro.carberry.multiplatform.core.extensions.observeAsState
import pro.carberry.multiplatform.features.auth.login.presentation.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel { LoginViewModel() }
) {

    val state by viewModel.viewStates().collectAsState()
    val action by viewModel.viewActions().observeAsState()
    LoginView(state) { event -> viewModel.obtainEvent(event) }

}
