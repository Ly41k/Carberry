import androidx.compose.ui.window.ComposeUIViewController
import pro.carberry.multiplatform.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
