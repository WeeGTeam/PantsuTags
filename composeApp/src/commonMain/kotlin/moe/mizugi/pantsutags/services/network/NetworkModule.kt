package moe.mizugi.pantsutags.services.network

import io.ktor.client.*
import moe.mizugi.pantsutags.api.repository.PantsuServerRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named(Backend.KaniServer)) {
        BackendConfig(
            "http://localhost:8000",
            HttpClient(),
        )
    }
    single {
        val backendConfig = get<BackendConfig>(named(Backend.KaniServer))
        PantsuServerRepository(
            backendConfig.baseUrl,
            backendConfig.httpClient,
        )
    }
}
