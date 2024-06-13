package pro.carberry.multiplatform.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import pro.carberry.multiplatform.core.utils.Constants.DEFAULT_DISPATCHER_QUALIFIER
import pro.carberry.multiplatform.core.utils.Constants.IO_DISPATCHER_QUALIFIER
import pro.carberry.multiplatform.core.utils.Constants.MAIN_DISPATCHER_QUALIFIER

val coroutineModule = DI.Module("coroutineModule") {
    bind<CoroutineDispatcher>(tag = DEFAULT_DISPATCHER_QUALIFIER) with singleton { Dispatchers.Default }
    bind<CoroutineDispatcher>(tag = IO_DISPATCHER_QUALIFIER) with singleton { Dispatchers.IO }
    bind<CoroutineDispatcher>(tag = MAIN_DISPATCHER_QUALIFIER) with singleton { Dispatchers.Main }
}
