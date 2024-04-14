package kmm.superApp.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }


fun createHttpClient(httpClientEngine: HttpClientEngine, json: Json) = HttpClient(httpClientEngine) {

    install(ContentNegotiation) {
        json(json)
    }
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                println("HTTP request: $message") // Print the HTTP request
            }
        }
        level = LogLevel.ALL
    }

    //        install(DefaultRequest) {
//                header("Authorization", prefs.getString("UserToken", null) ?: "")
//        }
//


}


