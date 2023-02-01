package navigation

import SplashScreen
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import navigation.NavigationSource
import admin.navigation.adminFlow
import admin.screens.creategame.CreateGameScreen

enum class NavigationSource {
    Desktop, Android, iOS
}

fun RootComposeBuilder.generateGraph(source: NavigationSource) {
    screen(name = NavigationTree.Splash.SplashScreen.name) {
        SplashScreen()
    }

    screen(name = NavigationTree.Main.Game.name) {
        Text(text = "Hello, Game Detail", color = Color.White)
    }

    authFlow()
    when (source) {
        NavigationSource.Android -> mainFlow()
        NavigationSource.Desktop -> {
            adminFlow()

            screen(name = NavigationTree.Admin.CreateGame.name) {
                CreateGameScreen()
            }
        }
        NavigationSource.iOS -> {}
    }
}