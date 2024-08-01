package pro.carberry.multiplatform.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import pro.carberry.multiplatform.core.store.ClearableBaseStore
import pro.carberry.multiplatform.store.NewOrderModel
import pro.carberry.multiplatform.store.NewOrderStore

val storeModule = DI.Module("storeModule") {
    bind<ClearableBaseStore<NewOrderModel>>() with singleton { NewOrderStore() }
}
