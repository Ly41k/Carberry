package pro.carberry.multiplatform.core.exceptions

import io.ktor.client.network.sockets.SocketTimeoutException

class DefaultExceptionService : ExceptionService {
    override fun logException(t: Throwable, message: String?) {
        if (t is SocketTimeoutException) return
        // TODO Need to add Firebase Crashlytics or similar
        println("$message - $t")
    }
}
