package pro.carberry.multiplatform.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import pro.carberry.multiplatform.repositories.policy.PolicyRepository
import pro.carberry.multiplatform.repositories.policy.PolicyRepositoryImpl

val repositoryModule = DI.Module("repositoryModule") {
    bind<PolicyRepository>() with singleton { PolicyRepositoryImpl() }
}
