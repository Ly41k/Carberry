package pro.carberry.multiplatform.features.auth.login.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn
import pro.carberry.multiplatform.core.presentation.BaseViewModel
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginAction
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginEvent
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginViewPartialState
import pro.carberry.multiplatform.features.auth.login.presentation.models.LoginViewState

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>() {

    private val emailValueChange =
        MutableSharedFlow<String>(extraBufferCapacity = 1, onBufferOverflow = DROP_OLDEST)
    private val passwordValueChange =
        MutableSharedFlow<String>(extraBufferCapacity = 1, onBufferOverflow = DROP_OLDEST)

    private val _state: StateFlow<LoginViewState>
        get() {

            val emailValueChangeFlow = emailValueChangeFlow()
            val passwordValueChangeFlow = passwordValueChangeFlow()

            return merge(
                emailValueChangeFlow,
                passwordValueChangeFlow
            )
                .catch {
                    // TODO Need to logging
                    println("_state throwable- $it")
                }
                .runningFold(LoginViewState(), ::viewStateReducer)
                .flowOn(Dispatchers.IO) // TODO Need to use custom Dispatchers via Di
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.Eagerly,
                    initialValue = LoginViewState()
                )
        }

    private fun viewStateReducer(
        prevState: LoginViewState,
        changes: LoginViewPartialState
    ): LoginViewState = when (changes) {
        is LoginViewPartialState.EmailValueChanged -> prevState.copy(emailValue = changes.value)
        is LoginViewPartialState.PasswordValueChanged -> prevState.copy(passwordValue = changes.value)
    }

    private fun emailValueChangeFlow(): Flow<LoginViewPartialState> {
        return emailValueChange.map<String, LoginViewPartialState> { LoginViewPartialState.EmailValueChanged(it) }
    }

    private fun passwordValueChangeFlow(): Flow<LoginViewPartialState> {
        return passwordValueChange.map<String, LoginViewPartialState> { LoginViewPartialState.PasswordValueChanged(it) }
    }

    override fun viewStates(): StateFlow<LoginViewState> = _state

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.EmailValueChanged -> obtainEmailChanged(viewEvent.value)
            is LoginEvent.PasswordValueChanged -> obtainPasswordChanged(viewEvent.value)
        }
    }

    private fun obtainEmailChanged(value: String) {
        println("obtainEmailChanged - $value")
        emailValueChange.tryEmit(value)
    }

    private fun obtainPasswordChanged(value: String) {
        passwordValueChange.tryEmit(value)
    }
}
