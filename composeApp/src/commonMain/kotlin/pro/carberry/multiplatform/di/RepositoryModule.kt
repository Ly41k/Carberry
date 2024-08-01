package pro.carberry.multiplatform.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pro.carberry.multiplatform.core.utils.Constants.DEFAULT_DISPATCHER_QUALIFIER
import pro.carberry.multiplatform.core.utils.Constants.IO_DISPATCHER_QUALIFIER
import pro.carberry.multiplatform.core.utils.Constants.MOCK_MAIN_INFO_DATA_SOURCE_QUALIFIER
import pro.carberry.multiplatform.repositories.neworder.NewOrderRepository
import pro.carberry.multiplatform.repositories.neworder.NewOrderRepositoryImpl
import pro.carberry.multiplatform.repositories.policy.PolicyRepository
import pro.carberry.multiplatform.repositories.policy.PolicyRepositoryImpl

val repositoryModule = DI.Module("repositoryModule") {
    bind<PolicyRepository>() with singleton {
        PolicyRepositoryImpl(
            defaultDispatcher = instance(tag = DEFAULT_DISPATCHER_QUALIFIER),
            ioDispatcher = instance(tag = IO_DISPATCHER_QUALIFIER),
        )
    }
    bind<NewOrderRepository>() with singleton {
        NewOrderRepositoryImpl(
            mainInfoDataSource = instance(tag = MOCK_MAIN_INFO_DATA_SOURCE_QUALIFIER)
        )
    }
}
