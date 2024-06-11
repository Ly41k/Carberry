package pro.carberry.multiplatform.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pro.carberry.multiplatform.mappers.PolicyMapper
import pro.carberry.multiplatform.mappers.PolicyMapperImpl

val mapperModule = DI.Module("mapperModule") {
    bind<PolicyMapper>() with singleton { PolicyMapperImpl(instance()) }
}
