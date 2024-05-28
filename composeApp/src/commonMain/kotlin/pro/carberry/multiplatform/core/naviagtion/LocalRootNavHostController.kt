package pro.carberry.multiplatform.core.naviagtion

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

val LocalRootNavHostController = staticCompositionLocalOf<NavHostController> { error("No default nav host") }
