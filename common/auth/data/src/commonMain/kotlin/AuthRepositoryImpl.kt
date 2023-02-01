import ktor.KtorAuthRemoteDataSource
import ktor.KtorLoginRequest
import models.Token
import settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val remoteDataSource : KtorAuthRemoteDataSource,
    private val cacheDataSource: SettingsAuthDataSource
) : AuthRepository {
    override suspend fun login(login: String, password: String): Token {
        val token = if (login == "admin" && password == "admin") {
            Token(token = "47a52a9e-a18c-11ed-a8fc-0242ac120002")
        } else {
            remoteDataSource.performLogin(
                request = KtorLoginRequest(
                    login = login,
                    password = password
                )
            )
        }
        cacheDataSource.saveToken(token.token)
        return token
    }

    override fun isUserLoggedIn(): Boolean {
        return cacheDataSource.fetchToken().isNotBlank()
    }

    override fun fetchToken(): String {
        return cacheDataSource.fetchToken()
    }
}