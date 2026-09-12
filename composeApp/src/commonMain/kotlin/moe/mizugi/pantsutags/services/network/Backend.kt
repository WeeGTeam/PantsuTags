package moe.mizugi.pantsutags.services.network

import io.ktor.client.*

enum class Backend {
    KaniServer,
}

class BackendConfig(
    val baseUrl: String,
    val httpClient: HttpClient,
)

