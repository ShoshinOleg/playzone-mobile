package admin.navigation

import navigation.tabs.*
import admin.screens.events.AdminEventsScreen
import admin.screens.games.AdminGamesScreen
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import navigation.NavigationTree

fun RootComposeBuilder.adminFlow() {
    bottomNavigation(
        name = NavigationTree.Admin.Dashboard.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(HomeTab()) {
            screen(name = NavigationTree.Admin.Games.name) {
                AdminGamesScreen()
            }
        }

        tab(EventsTab()) {
            screen(name = NavigationTree.Admin.Events.name) {
                AdminEventsScreen()
            }
        }
    }
}