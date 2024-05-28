import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import pro.carberry.multiplatform.CarberryApp
import pro.carberry.multiplatform.core.di.LocalPlatform
import pro.carberry.multiplatform.core.di.Platform
import pro.carberry.multiplatform.core.di.PlatformConfiguration
import pro.carberry.multiplatform.core.di.PlatformSDK

@Suppress("unused", "functionName")
fun MainViewController(): UIViewController = ComposeUIViewController {
    PlatformSDK.init(configuration = PlatformConfiguration())

    CompositionLocalProvider(
        LocalPlatform provides Platform.iOS
    ) {
        CarberryApp()
    }
}
