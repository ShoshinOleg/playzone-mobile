package navigation

import androidx.compose.material.Text
import navigation.tabs.*
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import screens.home.HomeScreen
import screens.search.SearchScreen

fun RootComposeBuilder.mainFlow() {
    bottomNavigation(
        name = NavigationTree.Main.Dashboard.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(HomeTab()) {
            screen(name = NavigationTree.Main.Home.name) {
                HomeScreen()
            }

            screen(name = NavigationTree.Main.Profile.name) {
                Text(text = "Hello, Profile")
            }
        }

        tab(SearchTab()) {
            screen(name = NavigationTree.Main.Search.name) {
                SearchScreen()
            }
        }

        tab(EventsTab()) {
            screen(name = NavigationTree.Main.Events.name) {

            }
        }

        tab(VideosTab()) {
            screen(name = NavigationTree.Main.Videos.name) {

            }
        }
    }
}