package pro.carberry.multiplatform.core.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun <T> StateFlow<T>.collectAsState(context: CoroutineContext = EmptyCoroutineContext): State<T> {
    return collectAsState(context = context)
}

@Composable
fun <T> SharedFlow<T>.observeAsState(context: CoroutineContext = EmptyCoroutineContext): State<T?> {
    return collectAsState(initial = null, context = context)
}
