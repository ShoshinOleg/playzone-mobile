package ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import models.Token

class KtorAuthRemoteDataSource(
    private val httpClient: HttpClient
) {

    suspend fun performLogin(request: KtorLoginRequest): Token {
        return httpClient.post {
            header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")
            url {
                path("login")
                setBody(request)
            }
        }.body()
    }
}