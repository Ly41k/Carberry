package pro.carberry.multiplatform.core.exceptions

interface ExceptionService {
    fun logException(t: Throwable, message: String? = null)
}
