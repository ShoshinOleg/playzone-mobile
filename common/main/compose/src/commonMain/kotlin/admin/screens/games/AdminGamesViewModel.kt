package admin.screens.games

import GamesRepository
import admin.screens.games.models.AdminGamesAction
import admin.screens.games.models.AdminGamesEvent
import admin.screens.games.models.AdminGamesViewState
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch

class AdminGamesViewModel : BaseSharedViewModel<AdminGamesViewState, AdminGamesAction, AdminGamesEvent>(
    initialState = AdminGamesViewState()
) {

    private val gamesRepository: GamesRepository = Inject.instance()

    init {
        fetchAllGames()
    }

    override fun obtainEvent(viewEvent: AdminGamesEvent) {
        when (viewEvent) {
            is AdminGamesEvent.AddGameClicked -> viewAction = AdminGamesAction.ShowAddGame
        }
    }

    private fun fetchAllGames() {
        viewModelScope.launch {
            val games = gamesRepository.fetchAllGames()
            viewState = viewState.copy(games = games)
        }
    }
}