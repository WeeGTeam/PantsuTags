package moe.mizugi.pantsutags.api.repository

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import moe.mizugi.pantsutags.api.generated.api.DefaultApi
import moe.mizugi.pantsutags.api.model.Image

class PantsuServerRepository(
    baseUrl: String = "http://localhost:8000"
) {
    private val httpClient = HttpClient()
    private val baseUrl = baseUrl
    private val defaultApi = DefaultApi(baseUrl = baseUrl, httpClient = httpClient)

    suspend fun getImage(id: String): Result<Image> {
        return try {
            // Use Ktor directly for binary responses - generated API expects JSON serialization
            val bytes: ByteArray = httpClient.get("$baseUrl/image/$id").body()
            Result.success(Image(id = id, data = bytes))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getImageThumbnail(id: String): Result<Image> {
        return try {
            // Use Ktor directly for binary responses - generated API expects JSON serialization
            val bytes: ByteArray = httpClient.get("$baseUrl/image/$id/thumbnail").body()
            Result.success(Image(id = id, data = bytes))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getTags(): Result<Unit> {
        return try {
            defaultApi.dummyGetTags()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun close() {
        httpClient.close()
    }
}
