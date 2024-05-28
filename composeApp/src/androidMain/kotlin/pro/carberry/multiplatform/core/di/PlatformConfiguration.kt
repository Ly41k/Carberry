package pro.carberry.multiplatform.core.di

import android.content.Context

actual class PlatformConfiguration constructor(val context: Context) {
    actual val appName: String
        get() = "Carberry" //TODO need to use string Resource
    actual val platform: Platform
        get() = Platform.Android
}
