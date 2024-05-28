package pro.carberry.multiplatform.core.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseViewModel<State : Any, Action, Event> : ViewModel() {
    private val _viewActions =
        MutableSharedFlow<Action?>(extraBufferCapacity = 1, onBufferOverflow = DROP_OLDEST)

    fun viewActions(): SharedFlow<Action?> = _viewActions.asSharedFlow()

    protected var viewAction: Action?
        get() = _viewActions.replayCache.last()
        set(value) {
            _viewActions.tryEmit(value)
        }

    abstract fun viewStates(): StateFlow<State>
    abstract fun obtainEvent(viewEvent: Event)
}
