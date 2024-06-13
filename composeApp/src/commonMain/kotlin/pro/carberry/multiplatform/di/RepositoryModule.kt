package pro.carberry.multiplatform.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pro.carberry.multiplatform.core.utils.Constants.DEFAULT_DISPATCHER_QUALIFIER
import pro.carberry.multiplatform.core.utils.Constants.IO_DISPATCHER_QUALIFIER
import pro.carberry.multiplatform.repositories.policy.PolicyRepository
import pro.carberry.multiplatform.repositories.policy.PolicyRepositoryImpl

val repositoryModule = DI.Module("repositoryModule") {
    bind<PolicyRepository>() with singleton {
        PolicyRepositoryImpl(
            defaultDispatcher = instance(tag = DEFAULT_DISPATCHER_QUALIFIER),
            ioDispatcher = instance(tag = IO_DISPATCHER_QUALIFIER),
        )
    }
}
