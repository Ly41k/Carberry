package pro.carberry.multiplatform.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pro.carberry.multiplatform.core.utils.Constants.IO_DISPATCHER_QUALIFIER
import pro.carberry.multiplatform.core.utils.Constants.MOCK_MAIN_INFO_DATA_SOURCE_QUALIFIER
import pro.carberry.multiplatform.repositories.neworder.data.MainInfoDataSource
import pro.carberry.multiplatform.repositories.neworder.data.MockMainInfoDataSourceImpl

val dataSourceModule = DI.Module("dataSourceModule") {
    bind<MainInfoDataSource>(tag = MOCK_MAIN_INFO_DATA_SOURCE_QUALIFIER) with singleton {
        MockMainInfoDataSourceImpl(
            json = instance(),
            ioDispatcher = instance(tag = IO_DISPATCHER_QUALIFIER),
            exceptionService = instance()
        )
    }
}
