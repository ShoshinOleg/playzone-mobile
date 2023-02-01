package admin.screens.creategame

import AuthRepository
import GamesRepository
import admin.screens.creategame.models.CreateGameAction
import admin.screens.creategame.models.CreateGameEvent
import admin.screens.creategame.models.CreateGameViewState
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import models.CreateGameInfo

class CreateGameViewModel :
    BaseSharedViewModel<CreateGameViewState, CreateGameAction, CreateGameEvent>(
        initialState = CreateGameViewState()
    ) {

    private val authRepository: AuthRepository = Inject.instance()
    private val gamesRepository: GamesRepository = Inject.instance()

    override fun obtainEvent(viewEvent: CreateGameEvent) {
        when (viewEvent) {
            is CreateGameEvent.TitleChanged ->
                viewState = viewState.copy(title = viewEvent.value)
            is CreateGameEvent.DescriptionChanged ->
                viewState = viewState.copy(description = viewEvent.value)
            is CreateGameEvent.SizeChanged ->
                viewState = viewState.copy(size = viewEvent.value)
            is CreateGameEvent.VersionChanged ->
                viewState = viewState.copy(version = viewEvent.value)
            is CreateGameEvent.SubmitChanges -> createGame()
        }
    }

    private fun createGame() {
        viewModelScope.launch {
            viewState = viewState.copy(isSending = true)
            try {
                val token = authRepository.fetchToken()
                gamesRepository.createGame(token, CreateGameInfo(
                    title = viewState.title,
                    description = viewState.description,
                    version = viewState.version,
                    size = viewState.size.toDouble()
                ))

                viewAction = CreateGameAction.CloseScreen
            } catch (e: Exception) {
                viewState = viewState.copy(isSending = false)
            }
        }
    }

}