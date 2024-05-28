package pro.carberry.multiplatform.core.di

actual class PlatformConfiguration {
    actual val appName: String
        get() = "Carberry" //TODO need to use string Resource
    actual val platform: Platform
        get() = Platform.iOS
}
