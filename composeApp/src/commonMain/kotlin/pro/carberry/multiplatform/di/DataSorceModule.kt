package pro.carberry.multiplatform.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pro.carberry.multiplatform.core.utils.Constants.IO_DISPATCHER_QUALIFIER
import pro.carberry.multiplatform.core.utils.Constants.MOCK_MAIN_INFO_DATA_SOURCE_QUALIFIER
import pro.carberry.multiplatform.core.utils.Constants.MOCK_SERVICES_DATA_SOURCE_QUALIFIER
import pro.carberry.multiplatform.datasource.neworder.MainInfoDataSource
import pro.carberry.multiplatform.datasource.neworder.MockMainInfoDataSourceImpl
import pro.carberry.multiplatform.datasource.neworder.MockServicesDataSourceImpl
import pro.carberry.multiplatform.datasource.neworder.ServicesDataSource

val dataSourceModule = DI.Module("dataSourceModule") {
    bind<MainInfoDataSource>(tag = MOCK_MAIN_INFO_DATA_SOURCE_QUALIFIER) with singleton {
        MockMainInfoDataSourceImpl(
            json = instance(),
            ioDispatcher = instance(tag = IO_DISPATCHER_QUALIFIER),
            exceptionService = instance()
        )
    }

    bind<ServicesDataSource>(tag = MOCK_SERVICES_DATA_SOURCE_QUALIFIER) with singleton {
        MockServicesDataSourceImpl(
            json = instance(),
            ioDispatcher = instance(tag = IO_DISPATCHER_QUALIFIER),
            exceptionService = instance()
        )
    }
}
