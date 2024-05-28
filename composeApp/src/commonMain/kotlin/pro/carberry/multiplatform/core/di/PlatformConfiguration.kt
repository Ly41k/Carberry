package pro.carberry.multiplatform.core.di

expect class PlatformConfiguration {
    val appName: String
    val platform: Platform
}
