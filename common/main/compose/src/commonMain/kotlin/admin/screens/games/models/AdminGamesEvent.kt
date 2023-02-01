package admin.screens.games.models

sealed class AdminGamesEvent {
    object AddGameClicked : AdminGamesEvent()
}