package pro.carberry.multiplatform

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import pro.carberry.multiplatform.core.di.LocalPlatform
import pro.carberry.multiplatform.core.di.Platform
import pro.carberry.multiplatform.core.di.PlatformConfiguration
import pro.carberry.multiplatform.core.di.PlatformSDK

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initPlatformSDK()
    }

    private fun AndroidApp.initPlatformSDK() =
        PlatformSDK.init(PlatformConfiguration(context = applicationContext))
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider(
                LocalPlatform provides Platform.Android
            ) {
                CarberryApp()
            }
        }
    }
}

internal actual fun openUrl(url: String?) {
    val uri = url?.let { Uri.parse(it) } ?: return
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = uri
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    AndroidApp.INSTANCE.startActivity(intent)
}