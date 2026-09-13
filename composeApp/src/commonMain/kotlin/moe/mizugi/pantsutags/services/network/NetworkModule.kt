package moe.mizugi.pantsutags.services.network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import moe.mizugi.pantsutags.api.repository.ImageDownloadRepository
import moe.mizugi.pantsutags.api.repository.ImageImportRepository
import moe.mizugi.pantsutags.api.repository.ImageRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named(Backend.KaniServer)) {
        BackendConfig(
            "http://localhost:8000",
            HttpClient {
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            prettyPrint = true
                            isLenient = true
                        }
                    )
                }
            },
        )
    }
    single {
        val backendConfig = get<BackendConfig>(named(Backend.KaniServer))
        ImageDownloadRepository(
            backendConfig.baseUrl,
            backendConfig.httpClient,
        )
    }
    single {
        val backendConfig = get<BackendConfig>(named(Backend.KaniServer))
        ImageImportRepository(
            backendConfig.baseUrl,
            backendConfig.httpClient,
        )
    }
    single {
        val backendConfig = get<BackendConfig>(named(Backend.KaniServer))
        ImageRepository(
            backendConfig.baseUrl,
            backendConfig.httpClient,
        )
    }
}
