package pro.carberry.multiplatform.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pro.carberry.multiplatform.interactors.policy.PolicyInteractor
import pro.carberry.multiplatform.interactors.policy.PolicyInteractorImpl

val interactorModule = DI.Module("interactorModule") {
    bind<PolicyInteractor>() with singleton { PolicyInteractorImpl(instance(), instance()) }
}
