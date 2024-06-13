package pro.carberry.multiplatform.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import pro.carberry.multiplatform.core.exceptions.DefaultExceptionService
import pro.carberry.multiplatform.core.exceptions.ExceptionService

val appModule = DI.Module("appModule") {
    bind<ExceptionService>() with singleton { DefaultExceptionService() }

    importAll(
        repositoryModule, interactorModule, mapperModule, coroutineModule
    )
}
