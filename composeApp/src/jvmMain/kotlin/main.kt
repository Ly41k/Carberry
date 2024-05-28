import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import pro.carberry.multiplatform.CarberryApp
import pro.carberry.multiplatform.core.di.LocalPlatform
import pro.carberry.multiplatform.core.di.Platform
import pro.carberry.multiplatform.core.di.PlatformConfiguration
import pro.carberry.multiplatform.core.di.PlatformSDK
import java.awt.Dimension

fun main() = application {
    PlatformSDK.init(configuration = PlatformConfiguration())
    Window(
        title = "Carberry", //TODO need to use string Resource
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        CompositionLocalProvider(
            LocalPlatform provides Platform.Desktop
        ) { CarberryApp() }
    }
}